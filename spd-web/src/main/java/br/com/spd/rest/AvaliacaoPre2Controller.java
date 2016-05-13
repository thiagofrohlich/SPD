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
import br.com.spd.domain.AvaliacaoPre2;
import br.com.spd.domain.repository.AvaliacaoPre2Repository;
import br.com.spd.exception.TransformerException;
import br.com.spd.transformer.impl.GenericTransformer;
import br.com.spd.wrapper.AvaliacaoPre2Wrapper;

@Controller
@RequestMapping("/avaliacaoPre2")
public class AvaliacaoPre2Controller {
	
	private final AvaliacaoPre2Repository avaliacaoPre2Repository;
	private final GenericTransformer transformer;

	@Autowired
	public AvaliacaoPre2Controller(AvaliacaoPre2Repository avaliacaoPre2Repository) {
		this.avaliacaoPre2Repository = avaliacaoPre2Repository;
		this.transformer = new GenericTransformer();
	}
	
	@ResponseBody
	@RequestMapping(value="/page/{page}", method=RequestMethod.GET)
	public AvaliacaoPre2Wrapper getAll(@PathVariable Integer page) throws TransformerException {
		Pageable pageRequest = new PageRequest(page, PageSize.DEFAULT);
		Page<AvaliacaoPre2> result = avaliacaoPre2Repository.findAll(pageRequest);
		AvaliacaoPre2Wrapper wrapper = new AvaliacaoPre2Wrapper(result);
		wrapper.setList(new ArrayList<br.com.spd.model.AvaliacaoPre2>(PageSize.DEFAULT));
		
		for(AvaliacaoPre2 avaliacaoPre2 : result) {
			br.com.spd.model.AvaliacaoPre2 p = new br.com.spd.model.AvaliacaoPre2();
			transformer.transform(avaliacaoPre2, p);
			wrapper.getList().add(p);
		}
		
		return wrapper;
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public br.com.spd.model.AvaliacaoPre2 getOne(@PathVariable final Long id) throws TransformerException {
		AvaliacaoPre2 result = avaliacaoPre2Repository.findOne(id);
		br.com.spd.model.AvaliacaoPre2 model = new br.com.spd.model.AvaliacaoPre2();
		transformer.transform(result, model);
		return model;
	}
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.POST)
	public br.com.spd.model.AvaliacaoPre2 create(@RequestBody br.com.spd.model.AvaliacaoPre2 avaliacaoPre2) throws TransformerException {
		return saveOrUpdate(avaliacaoPre2);
	}

	@ResponseBody
	@RequestMapping(method=RequestMethod.PUT)
	public br.com.spd.model.AvaliacaoPre2 update(@RequestBody br.com.spd.model.AvaliacaoPre2 avaliacaoPre2) throws TransformerException {
		return saveOrUpdate(avaliacaoPre2);
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public boolean delete(@PathVariable final Long id) {
		avaliacaoPre2Repository.delete(id);
		return avaliacaoPre2Repository.findOne(id) == null;
	}
	
	private br.com.spd.model.AvaliacaoPre2 saveOrUpdate(final br.com.spd.model.AvaliacaoPre2 avaliacaoPre2)
			throws TransformerException {
		AvaliacaoPre2 p = new AvaliacaoPre2();
		transformer.transform(avaliacaoPre2, p);
		p = avaliacaoPre2Repository.save(p);
		br.com.spd.model.AvaliacaoPre2 model = new br.com.spd.model.AvaliacaoPre2();
		transformer.transform(p, model);
		return model;
	}

}
