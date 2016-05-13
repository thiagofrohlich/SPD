package br.com.spd.rest;

import java.util.ArrayList;
import java.util.List;

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
import br.com.spd.domain.Turma;
import br.com.spd.domain.repository.TurmaRepository;
import br.com.spd.exception.TransformerException;
import br.com.spd.transformer.impl.GenericTransformer;
import br.com.spd.wrapper.TurmaWrapper;

@Controller
@RequestMapping("/turma")
public class TurmaController {
	
	private final TurmaRepository turmaRepository;
	private final GenericTransformer transformer;

	@Autowired
	public TurmaController(TurmaRepository turmaRepository) {
		this.turmaRepository = turmaRepository;
		this.transformer = new GenericTransformer();
	}
	
	@ResponseBody
	@RequestMapping(value="/page/{page}", method=RequestMethod.GET)
	public TurmaWrapper getAll(@PathVariable Integer page) throws TransformerException {
		Pageable pageRequest = new PageRequest(page, PageSize.DEFAULT);
		Page<Turma> result = turmaRepository.findAll(pageRequest);
		TurmaWrapper wrapper = new TurmaWrapper(result);
		wrapper.setList(new ArrayList<br.com.spd.model.Turma>(PageSize.DEFAULT));
		
		for(Turma turma : result) {
			br.com.spd.model.Turma p = new br.com.spd.model.Turma();
			transformer.transform(turma, p);
			wrapper.getList().add(p);
		}
		
		return wrapper;
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public br.com.spd.model.Turma getOne(@PathVariable final Long id) throws TransformerException {
		Turma result = turmaRepository.findOne(id);
		br.com.spd.model.Turma model = new br.com.spd.model.Turma();
		transformer.transform(result, model);
		return model;
	}
	
	@ResponseBody
	@RequestMapping(value="/descricao/{descricao}", method=RequestMethod.GET)
	public TurmaWrapper getByNome(@PathVariable String descricao) throws TransformerException {
		List<Turma> result = turmaRepository.findByDescricaoLike("%"+descricao+"%");
		TurmaWrapper wrapper = new TurmaWrapper();
		wrapper.setList(new ArrayList<br.com.spd.model.Turma>(PageSize.DEFAULT));
		
		for(Turma turma : result) {
			br.com.spd.model.Turma o = new br.com.spd.model.Turma();
			transformer.transform(turma, o);
			wrapper.getList().add(o);
		}
		
		return wrapper;
	}

	@ResponseBody
	@RequestMapping(method=RequestMethod.POST)
	public br.com.spd.model.Turma create(@RequestBody br.com.spd.model.Turma turma) throws TransformerException {
		return saveOrUpdate(turma);
	}

	@ResponseBody
	@RequestMapping(method=RequestMethod.PUT)
	public br.com.spd.model.Turma update(@RequestBody br.com.spd.model.Turma turma) throws TransformerException {
		return saveOrUpdate(turma);
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public boolean delete(@PathVariable final Long id) {
		turmaRepository.delete(id);
		return turmaRepository.findOne(id) == null;
	}
	
	private br.com.spd.model.Turma saveOrUpdate(final br.com.spd.model.Turma turma)
			throws TransformerException {
		Turma p = new Turma();
		transformer.transform(turma, p);
		p = turmaRepository.save(p);
		br.com.spd.model.Turma model = new br.com.spd.model.Turma();
		transformer.transform(p, model);
		return model;
	}

}
