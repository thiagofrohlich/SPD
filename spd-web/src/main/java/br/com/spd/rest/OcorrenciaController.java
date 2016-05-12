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
import br.com.spd.domain.Ocorrencia;
import br.com.spd.domain.repository.OcorrenciaRepository;
import br.com.spd.exception.TransformerException;
import br.com.spd.transformer.impl.GenericTransformer;
import br.com.spd.wrapper.OcorrenciaWrapper;

@Controller
@RequestMapping("/ocorrencia")
public class OcorrenciaController {
	
	private final OcorrenciaRepository ocorrenciaRepository;
	private final GenericTransformer transformer;

	@Autowired
	public OcorrenciaController(OcorrenciaRepository ocorrenciaRepository) {
		this.ocorrenciaRepository = ocorrenciaRepository;
		this.transformer = new GenericTransformer();
	}
	
	@ResponseBody
	@RequestMapping(value="/page/{page}", method=RequestMethod.GET)
	public OcorrenciaWrapper getAll(@PathVariable Integer page) throws TransformerException {
		Pageable pageRequest = new PageRequest(page, PageSize.DEFAULT);
		Page<Ocorrencia> result = ocorrenciaRepository.findAll(pageRequest);
		OcorrenciaWrapper wrapper = new OcorrenciaWrapper(result);
		wrapper.setList(new ArrayList<br.com.spd.model.Ocorrencia>(PageSize.DEFAULT));
		
		for(Ocorrencia ocorrencia : result) {
			br.com.spd.model.Ocorrencia p = new br.com.spd.model.Ocorrencia();
			transformer.transform(ocorrencia, p);
			wrapper.getList().add(p);
		}
		
		return wrapper;
	}
	
	
	
	

	@ResponseBody
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public br.com.spd.model.Ocorrencia getOne(@PathVariable final Long id) throws TransformerException {
		Ocorrencia result = ocorrenciaRepository.findOne(id);
		br.com.spd.model.Ocorrencia model = new br.com.spd.model.Ocorrencia();
		transformer.transform(result, model);
		return model;
	}
	
	@ResponseBody
	@RequestMapping(value="/descricao/{descricao}", method=RequestMethod.GET)
	public OcorrenciaWrapper getByNome(@PathVariable String descricao) throws TransformerException {
		List<Ocorrencia> result = ocorrenciaRepository.findByDescricaoLike("%"+descricao+"%");
		OcorrenciaWrapper wrapper = new OcorrenciaWrapper();
		wrapper.setList(new ArrayList<br.com.spd.model.Ocorrencia>(PageSize.DEFAULT));
		
		for(Ocorrencia ocorrencia : result) {
			br.com.spd.model.Ocorrencia o = new br.com.spd.model.Ocorrencia();
			transformer.transform(ocorrencia, o);
		}
		
		return wrapper;
	}

	@ResponseBody
	@RequestMapping(method=RequestMethod.POST)
	public br.com.spd.model.Ocorrencia create(@RequestBody br.com.spd.model.Ocorrencia ocorrencia) throws TransformerException {
		return saveOrUpdate(ocorrencia);
	}

	@ResponseBody
	@RequestMapping(method=RequestMethod.PUT)
	public br.com.spd.model.Ocorrencia update(@RequestBody br.com.spd.model.Ocorrencia ocorrencia) throws TransformerException {
		return saveOrUpdate(ocorrencia);
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public boolean delete(@PathVariable final Long id) {
		ocorrenciaRepository.delete(id);
		return ocorrenciaRepository.findOne(id) == null;
	}
	
	private br.com.spd.model.Ocorrencia saveOrUpdate(final br.com.spd.model.Ocorrencia ocorrencia)
			throws TransformerException {
		Ocorrencia p = new Ocorrencia();
		transformer.transform(ocorrencia, p);
		p = ocorrenciaRepository.save(p);
		br.com.spd.model.Ocorrencia model = new br.com.spd.model.Ocorrencia();
		transformer.transform(p, model);
		return model;
	}

}
