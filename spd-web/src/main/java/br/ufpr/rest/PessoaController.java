package br.ufpr.rest;

import java.lang.reflect.InvocationTargetException;
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
import br.com.spd.domain.Pessoa;
import br.com.spd.domain.repository.PessoaRepository;
import br.com.spd.transformer.impl.GenericTransformer;
import br.com.spd.wrapper.PessoaWrapper;

@Controller
@RequestMapping("/pessoa")
public class PessoaController {
	
	private final PessoaRepository pessoaRepository;
	private final GenericTransformer transformer;

	@Autowired
	public PessoaController(PessoaRepository pessoaRepository) {
		this.pessoaRepository = pessoaRepository;
		this.transformer = new GenericTransformer();
	}
	
	@ResponseBody
	@RequestMapping(value="/page/{page}", method=RequestMethod.GET)
	public PessoaWrapper getAll(@PathVariable Integer page) throws IllegalArgumentException, IllegalAccessException, InstantiationException, InvocationTargetException {
		Pageable pageRequest = new PageRequest(page, PageSize.DEFAULT);
		Page<Pessoa> result = pessoaRepository.findAll(pageRequest);
		PessoaWrapper wrapper = new PessoaWrapper(result);
		wrapper.setList(new ArrayList<br.com.spd.model.Pessoa>(PageSize.DEFAULT));
		
		for(Pessoa pessoa : result) {
			br.com.spd.model.Pessoa p = new br.com.spd.model.Pessoa();
			transformer.transform(pessoa, p);
			wrapper.getList().add(p);
		}
		
		return wrapper;
	}
	
	@ResponseBody
	@RequestMapping(value="/nome/{nome}", method=RequestMethod.GET)
	public PessoaWrapper getByNome(@PathVariable String nome) throws IllegalArgumentException, IllegalAccessException, InstantiationException, InvocationTargetException {
		List<Pessoa> result = pessoaRepository.findByNome("%"+nome+"%");
		PessoaWrapper wrapper = new PessoaWrapper();
		wrapper.setList(new ArrayList<br.com.spd.model.Pessoa>(PageSize.DEFAULT));
		
		for(Pessoa pessoa : result) {
			br.com.spd.model.Pessoa p = new br.com.spd.model.Pessoa();
			transformer.transform(pessoa, p);
		}
		
		return wrapper;
	}
	
	
	

	@ResponseBody
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public br.com.spd.model.Pessoa getOne(@PathVariable final Long id) throws IllegalArgumentException, IllegalAccessException, InstantiationException, InvocationTargetException {
		Pessoa result = pessoaRepository.findOne(id);
		br.com.spd.model.Pessoa model = new br.com.spd.model.Pessoa();
		transformer.transform(result, model);
		return model;
	}
	
	@ResponseBody
	@RequestMapping(value="/cnpj/{cnpj}", method=RequestMethod.GET)
	public br.com.spd.model.Pessoa getByCNPJ(@PathVariable final String cnpj) throws IllegalArgumentException, IllegalAccessException, InstantiationException, InvocationTargetException {
		Pessoa result = pessoaRepository.findByCNPJ(cnpj);
		if(result != null){
			br.com.spd.model.Pessoa model = new br.com.spd.model.Pessoa();
			transformer.transform(result, model);
			return model;
		}else{
			return null;
		}
		
	}
	
	@ResponseBody
	@RequestMapping(value="/cpf/{cpf}", method=RequestMethod.GET)
	public br.com.spd.model.Pessoa getByCPF(@PathVariable final String cpf) throws IllegalArgumentException, IllegalAccessException, InstantiationException, InvocationTargetException {
		Pessoa result = pessoaRepository.findByCPF(cpf);
		if(result != null){
			br.com.spd.model.Pessoa model = new br.com.spd.model.Pessoa();
			transformer.transform(result, model);
			return model;
		}else{
			return null;
		}
		
	}
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.POST)
	public br.com.spd.model.Pessoa create(@RequestBody br.com.spd.model.Pessoa pessoa) throws IllegalArgumentException, IllegalAccessException, InstantiationException, InvocationTargetException {
		return saveOrUpdate(pessoa);
	}

	@ResponseBody
	@RequestMapping(method=RequestMethod.PUT)
	public br.com.spd.model.Pessoa update(@RequestBody br.com.spd.model.Pessoa pessoa) throws IllegalArgumentException, IllegalAccessException, InstantiationException, InvocationTargetException {
		return saveOrUpdate(pessoa);
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public boolean delete(@PathVariable final Long id) {
		pessoaRepository.delete(id);
		return pessoaRepository.findOne(id) == null;
	}
	
	private br.com.spd.model.Pessoa saveOrUpdate(final br.com.spd.model.Pessoa pessoa)
			throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
		Pessoa p = new Pessoa();
		transformer.transform(pessoa, p);
		p = pessoaRepository.save(p);
		br.com.spd.model.Pessoa model = new br.com.spd.model.Pessoa();
		transformer.transform(p, model);
		return model;
	}

}
