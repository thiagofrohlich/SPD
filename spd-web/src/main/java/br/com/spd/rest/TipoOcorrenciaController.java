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
import br.com.spd.domain.TipoOcorrencia;
import br.com.spd.domain.repository.TipoOcorrenciaRepository;
import br.com.spd.exception.TransformerException;
import br.com.spd.transformer.impl.GenericTransformer;
import br.com.spd.wrapper.TipoOcorrenciaWrapper;

@Controller
@RequestMapping("/tipoOcorrencia")
public class TipoOcorrenciaController {
	
	private final TipoOcorrenciaRepository tipoOcorrenciaRepository;
	private final GenericTransformer transformer;

	@Autowired
	public TipoOcorrenciaController(TipoOcorrenciaRepository tipoOcorrenciaRepository) {
		this.tipoOcorrenciaRepository = tipoOcorrenciaRepository;
		this.transformer = new GenericTransformer();
	}
	
	@ResponseBody
	@RequestMapping(value="/page/{page}", method=RequestMethod.GET)
	public TipoOcorrenciaWrapper getAllInPages(@PathVariable Integer page) throws TransformerException {
		Pageable pageRequest = new PageRequest(page, PageSize.DEFAULT);
		Page<TipoOcorrencia> result = tipoOcorrenciaRepository.findAll(pageRequest);
		TipoOcorrenciaWrapper wrapper = new TipoOcorrenciaWrapper(result);
		wrapper.setList(new ArrayList<br.com.spd.model.TipoOcorrencia>(PageSize.DEFAULT));
		
		for(TipoOcorrencia tipoOcorrencia : result) {
			br.com.spd.model.TipoOcorrencia p = new br.com.spd.model.TipoOcorrencia();
			transformer.transform(tipoOcorrencia, p);
			wrapper.getList().add(p);
		}
		
		return wrapper;
	}
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.GET)
	public TipoOcorrenciaWrapper getAll(@PathVariable Integer page) throws TransformerException {
		List<TipoOcorrencia> result = (List<TipoOcorrencia>) tipoOcorrenciaRepository.findAll();
		TipoOcorrenciaWrapper wrapper = new TipoOcorrenciaWrapper();
		wrapper.setList(new ArrayList<br.com.spd.model.TipoOcorrencia>(PageSize.DEFAULT));
		
		for(TipoOcorrencia tipoOcorrencia : result) {
			br.com.spd.model.TipoOcorrencia p = new br.com.spd.model.TipoOcorrencia();
			transformer.transform(tipoOcorrencia, p);
			wrapper.getList().add(p);
		}
		
		return wrapper;
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public br.com.spd.model.TipoOcorrencia getOne(@PathVariable final Long id) throws TransformerException {
		TipoOcorrencia result = tipoOcorrenciaRepository.findOne(id);
		br.com.spd.model.TipoOcorrencia model = new br.com.spd.model.TipoOcorrencia();
		transformer.transform(result, model);
		return model;
	}
	
	@ResponseBody
	@RequestMapping(value="/descricao/{descricao}", method=RequestMethod.GET)
	public TipoOcorrenciaWrapper getByNome(@PathVariable String descricao) throws TransformerException {
		List<TipoOcorrencia> result = tipoOcorrenciaRepository.findByDescricaoLike("%"+descricao+"%");
		TipoOcorrenciaWrapper wrapper = new TipoOcorrenciaWrapper();
		wrapper.setList(new ArrayList<br.com.spd.model.TipoOcorrencia>(PageSize.DEFAULT));
		
		for(TipoOcorrencia tipoOcorrencia : result) {
			br.com.spd.model.TipoOcorrencia o = new br.com.spd.model.TipoOcorrencia();
			transformer.transform(tipoOcorrencia, o);
			wrapper.getList().add(o);
		}
		
		return wrapper;
	}

	@ResponseBody
	@RequestMapping(method=RequestMethod.POST)
	public br.com.spd.model.TipoOcorrencia create(@RequestBody br.com.spd.model.TipoOcorrencia tipoOcorrencia) throws TransformerException {
		return saveOrUpdate(tipoOcorrencia);
	}

	@ResponseBody
	@RequestMapping(method=RequestMethod.PUT)
	public br.com.spd.model.TipoOcorrencia update(@RequestBody br.com.spd.model.TipoOcorrencia tipoOcorrencia) throws TransformerException {
		return saveOrUpdate(tipoOcorrencia);
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public boolean delete(@PathVariable final Long id) {
		tipoOcorrenciaRepository.delete(id);
		return tipoOcorrenciaRepository.findOne(id) == null;
	}
	
	private br.com.spd.model.TipoOcorrencia saveOrUpdate(final br.com.spd.model.TipoOcorrencia tipoOcorrencia)
			throws TransformerException {
		TipoOcorrencia p = new TipoOcorrencia();
		transformer.transform(tipoOcorrencia, p);
		p = tipoOcorrenciaRepository.save(p);
		br.com.spd.model.TipoOcorrencia model = new br.com.spd.model.TipoOcorrencia();
		transformer.transform(p, model);
		return model;
	}

}
