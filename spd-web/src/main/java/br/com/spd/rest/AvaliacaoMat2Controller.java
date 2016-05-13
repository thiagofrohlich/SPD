package br.com.spd.rest;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.spd.PageSize;
import br.com.spd.domain.AvaliacaoMat2;
import br.com.spd.domain.repository.AvaliacaoMat2Repository;
import br.com.spd.exception.TransformerException;
import br.com.spd.transformer.impl.GenericTransformer;
import br.com.spd.wrapper.AvaliacaoMat2Wrapper;

@Controller
@RequestMapping("/avaliacaoMat2")
public class AvaliacaoMat2Controller {
	
	private final AvaliacaoMat2Repository avaliacaoMat2Repository;
	private final GenericTransformer transformer;

	@Autowired
	public AvaliacaoMat2Controller(AvaliacaoMat2Repository avaliacaoMat2Repository) {
		this.avaliacaoMat2Repository = avaliacaoMat2Repository;
		this.transformer = new GenericTransformer();
	}
	
	@ResponseBody
	@RequestMapping(value="/page/{page}", method=RequestMethod.GET)
	public AvaliacaoMat2Wrapper getAll(@PathVariable Integer page) throws TransformerException {
		Pageable pageRequest = new PageRequest(page, PageSize.DEFAULT);
		Page<AvaliacaoMat2> result = avaliacaoMat2Repository.findAll(pageRequest);
		AvaliacaoMat2Wrapper wrapper = new AvaliacaoMat2Wrapper(result);
		wrapper.setList(new ArrayList<br.com.spd.model.AvaliacaoMat2>(PageSize.DEFAULT));
		
		for(AvaliacaoMat2 avaliacaoMat2 : result) {
			br.com.spd.model.AvaliacaoMat2 p = new br.com.spd.model.AvaliacaoMat2();
			transformer.transform(avaliacaoMat2, p);
			wrapper.getList().add(p);
		}
		
		return wrapper;
	}

	@ResponseBody
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public br.com.spd.model.AvaliacaoMat2 getOne(@PathVariable final Long id) throws TransformerException {
		AvaliacaoMat2 result = avaliacaoMat2Repository.findOne(id);
		br.com.spd.model.AvaliacaoMat2 model = new br.com.spd.model.AvaliacaoMat2();
		transformer.transform(result, model);
		return model;
	}
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.POST)
	public br.com.spd.model.AvaliacaoMat2 create(@RequestBody br.com.spd.model.AvaliacaoMat2 avaliacaoMat2) throws TransformerException {
		return saveOrUpdate(avaliacaoMat2);
	}

	@ResponseBody
	@RequestMapping(method=RequestMethod.PUT)
	public br.com.spd.model.AvaliacaoMat2 update(@RequestBody br.com.spd.model.AvaliacaoMat2 avaliacaoMat2) throws TransformerException {
		return saveOrUpdate(avaliacaoMat2);
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public boolean delete(@PathVariable final Long id) {
		avaliacaoMat2Repository.delete(id);
		return avaliacaoMat2Repository.findOne(id) == null;
	}
	
	private br.com.spd.model.AvaliacaoMat2 saveOrUpdate(final br.com.spd.model.AvaliacaoMat2 avaliacaoMat2)
			throws TransformerException {
		AvaliacaoMat2 p = new AvaliacaoMat2();
		transformer.transform(avaliacaoMat2, p);
		p = avaliacaoMat2Repository.save(p);
		br.com.spd.model.AvaliacaoMat2 model = new br.com.spd.model.AvaliacaoMat2();
		transformer.transform(p, model);
		return model;
	}

}
