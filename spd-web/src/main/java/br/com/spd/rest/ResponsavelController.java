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
import br.com.spd.domain.Aluno;
import br.com.spd.domain.Pessoa;
import br.com.spd.domain.Responsavel;
import br.com.spd.domain.repository.PessoaRepository;
import br.com.spd.domain.repository.ResponsavelRepository;
import br.com.spd.exception.TransformerException;
import br.com.spd.transformer.impl.ResponsavelTransformer;
import br.com.spd.wrapper.ResponsavelWrapper;

@Controller
@RequestMapping("/responsavel")
public class ResponsavelController {
	
	private final ResponsavelRepository responsavelRepository;
	private final PessoaRepository pessoaRepository;
	private final ResponsavelTransformer transformer;

	@Autowired
	public ResponsavelController(ResponsavelRepository responsavelRepository, PessoaRepository pessoaRepository) {
		this.responsavelRepository = responsavelRepository;
		this.pessoaRepository = pessoaRepository;
		this.transformer = new ResponsavelTransformer();
	}
	
	@ResponseBody
	@RequestMapping(value="/page/{page}", method=RequestMethod.GET)
	public ResponsavelWrapper getAll(@PathVariable Integer page) throws TransformerException {
		Pageable pageRequest = new PageRequest(page, PageSize.DEFAULT);
		Page<Responsavel> result = responsavelRepository.findAll(pageRequest);
		ResponsavelWrapper wrapper = new ResponsavelWrapper(result);
		wrapper.setList(new ArrayList<br.com.spd.model.Responsavel>(PageSize.DEFAULT));
		
		for(Responsavel responsavel : result) {
			br.com.spd.model.Responsavel p = new br.com.spd.model.Responsavel();
			transformer.transform(responsavel, p);
			wrapper.getList().add(p);
		}
		
		return wrapper;
	}
	
	@ResponseBody
	@RequestMapping(value="/nome/{nome}", method=RequestMethod.GET)
	public ResponsavelWrapper getByNome(@PathVariable String nome) throws TransformerException {
		List<Responsavel> result = responsavelRepository.findByPessoaNomeLike("%"+nome+"%");
		ResponsavelWrapper wrapper = new ResponsavelWrapper();
		wrapper.setList(new ArrayList<br.com.spd.model.Responsavel>(PageSize.DEFAULT));
		
		for(Responsavel responsavel : result) {
			br.com.spd.model.Responsavel p = new br.com.spd.model.Responsavel();
			transformer.transform(responsavel, p);
			wrapper.getList().add(p);
		}
		
		return wrapper;
	}

	@ResponseBody
	@RequestMapping(value="/aluno/{matricula}", method=RequestMethod.GET)
	public ResponsavelWrapper getByAluno(@PathVariable Long matricula) throws TransformerException {
		Aluno aluno = new Aluno();
		aluno.setMatricula(matricula);
		List<Responsavel> result = responsavelRepository.findByAluno(aluno);
		
		ResponsavelWrapper wrapper = new ResponsavelWrapper();
		wrapper.setList(new ArrayList<br.com.spd.model.Responsavel>(PageSize.DEFAULT));
		
		for(Responsavel responsavel : result) {
			br.com.spd.model.Responsavel p = new br.com.spd.model.Responsavel();
			transformer.transform(responsavel, p);
			wrapper.getList().add(p);
		}
		
		return wrapper;
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public br.com.spd.model.Responsavel getOne(@PathVariable final Long id) throws TransformerException {
		Responsavel result = responsavelRepository.findOne(id);
		br.com.spd.model.Responsavel model = new br.com.spd.model.Responsavel();
		transformer.transform(result, model);
		return model;
	}
	
	@ResponseBody
	@RequestMapping(value="/cpf/{cpf}", method=RequestMethod.GET)
	public br.com.spd.model.Responsavel getByCPF(@PathVariable final String cpf) throws TransformerException {
		Responsavel result = responsavelRepository.findByPessoaCpf(cpf);
		if(result != null){
			br.com.spd.model.Responsavel model = new br.com.spd.model.Responsavel();
			transformer.transform(result, model);
			return model;
		}else{
			return null;
		}
		
	}
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.POST)
	public br.com.spd.model.Responsavel create(@RequestBody br.com.spd.model.Responsavel responsavel) throws TransformerException {
		return saveOrUpdate(responsavel);
	}

	@ResponseBody
	@RequestMapping(method=RequestMethod.PUT)
	public br.com.spd.model.Responsavel update(@RequestBody br.com.spd.model.Responsavel responsavel) throws TransformerException {
		return saveOrUpdate(responsavel);
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public boolean delete(@PathVariable final Long id) {
		responsavelRepository.delete(id);
		return responsavelRepository.findOne(id) == null;
	}
	
	private br.com.spd.model.Responsavel saveOrUpdate(final br.com.spd.model.Responsavel responsavel)
			throws TransformerException {
//		Transform to Domain
		Responsavel resp = new Responsavel();
		transformer.transform(responsavel, resp);
		
//		Save Pessoa and Responsavel
		resp = save(resp);
		
//		Transform to Model
		br.com.spd.model.Responsavel model = new br.com.spd.model.Responsavel();
		transformer.transform(resp, model);
		
		return model;
	}

	private Responsavel save(Responsavel responsavel) {
		Pessoa pessoa = pessoaRepository.save(responsavel.getPessoa());
		responsavel.setPessoa(pessoa);
		return responsavelRepository.save(responsavel);
	}

}
