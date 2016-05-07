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
import br.com.spd.domain.AvaliacaoPre1;
import br.com.spd.domain.repository.AvaliacaoPre1Repository;
import br.com.spd.exception.TransformerException;
import br.com.spd.transformer.impl.GenericTransformer;
import br.com.spd.wrapper.AvaliacaoPre1Wrapper;

@Controller
@RequestMapping("/avaliacaoPre1")
public class AvaliacaoPre1Controller {
	
	private final AvaliacaoPre1Repository avaliacaoPre1Repository;
	private final GenericTransformer transformer;

	@Autowired
	public AvaliacaoPre1Controller(AvaliacaoPre1Repository avaliacaoPre1Repository) {
		this.avaliacaoPre1Repository = avaliacaoPre1Repository;
		this.transformer = new GenericTransformer();
	}
	
	@ResponseBody
	@RequestMapping(value="/page/{page}", method=RequestMethod.GET)
	public AvaliacaoPre1Wrapper getAll(@PathVariable Integer page) throws TransformerException {
		Pageable pageRequest = new PageRequest(page, PageSize.DEFAULT);
		Page<AvaliacaoPre1> result = avaliacaoPre1Repository.findAll(pageRequest);
		AvaliacaoPre1Wrapper wrapper = new AvaliacaoPre1Wrapper(result);
		wrapper.setList(new ArrayList<br.com.spd.model.AvaliacaoPre1>(PageSize.DEFAULT));
		
		for(AvaliacaoPre1 avaliacaoPre1 : result) {
			br.com.spd.model.AvaliacaoPre1 p = new br.com.spd.model.AvaliacaoPre1();
			transformer.transform(avaliacaoPre1, p);
			wrapper.getList().add(p);
		}
		
		return wrapper;
	}
	
	
	
	

	@ResponseBody
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public br.com.spd.model.AvaliacaoPre1 getOne(@PathVariable final Long id) throws TransformerException {
		AvaliacaoPre1 result = avaliacaoPre1Repository.findOne(id);
		br.com.spd.model.AvaliacaoPre1 model = new br.com.spd.model.AvaliacaoPre1();
		transformer.transform(result, model);
		return model;
	}
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.POST)
	public br.com.spd.model.AvaliacaoPre1 create(@RequestBody br.com.spd.model.AvaliacaoPre1 avaliacaoPre1) throws TransformerException {
		return saveOrUpdate(avaliacaoPre1);
	}

	@ResponseBody
	@RequestMapping(method=RequestMethod.PUT)
	public br.com.spd.model.AvaliacaoPre1 update(@RequestBody br.com.spd.model.AvaliacaoPre1 avaliacaoPre1) throws TransformerException {
		return saveOrUpdate(avaliacaoPre1);
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public boolean delete(@PathVariable final Long id) {
		avaliacaoPre1Repository.delete(id);
		return avaliacaoPre1Repository.findOne(id) == null;
	}
	
	private br.com.spd.model.AvaliacaoPre1 saveOrUpdate(final br.com.spd.model.AvaliacaoPre1 avaliacaoPre1)
			throws TransformerException {
		AvaliacaoPre1 p = new AvaliacaoPre1();
		transformer.transform(avaliacaoPre1, p);
		p = avaliacaoPre1Repository.save(p);
		br.com.spd.model.AvaliacaoPre1 model = new br.com.spd.model.AvaliacaoPre1();
		transformer.transform(p, model);
		return model;
	}

}
