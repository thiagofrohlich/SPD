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
import br.com.spd.domain.Pessoa;
import br.com.spd.domain.Professor;
import br.com.spd.domain.repository.PessoaRepository;
import br.com.spd.domain.repository.ProfessorRepository;
import br.com.spd.exception.TransformerException;
import br.com.spd.transformer.impl.ProfessorTransformer;
import br.com.spd.wrapper.ProfessorWrapper;

@Controller
@RequestMapping("/professor")
public class ProfessorController {
	
	private final ProfessorRepository professorRepository;
	private final PessoaRepository pessoaRepository;
	private final ProfessorTransformer transformer;

	@Autowired
	public ProfessorController(ProfessorRepository professorRepository, PessoaRepository pessoaRepository) {
		this.professorRepository = professorRepository;
		this.pessoaRepository = pessoaRepository;
		this.transformer = new ProfessorTransformer();
	}
	
	@ResponseBody
	@RequestMapping(value="/page/{page}", method=RequestMethod.GET)
	public ProfessorWrapper getAll(@PathVariable Integer page) throws TransformerException {
		Pageable pageRequest = new PageRequest(page, PageSize.DEFAULT);
		Page<Professor> result = professorRepository.findAll(pageRequest);
		ProfessorWrapper wrapper = new ProfessorWrapper(result);
		wrapper.setList(new ArrayList<br.com.spd.model.Professor>(PageSize.DEFAULT));
		
		for(Professor professor : result) {
			br.com.spd.model.Professor p = new br.com.spd.model.Professor();
			transformer.transform(professor, p);
			wrapper.getList().add(p);
		}
		
		return wrapper;
	}
	
	@ResponseBody
	@RequestMapping(value="/nome/{nome}", method=RequestMethod.GET)
	public ProfessorWrapper getByNome(@PathVariable String nome) throws TransformerException {
		List<Professor> result = professorRepository.findByPessoaNomeLikeIgnoreCase("%"+nome+"%");
		ProfessorWrapper wrapper = new ProfessorWrapper();
		wrapper.setList(new ArrayList<br.com.spd.model.Professor>(PageSize.DEFAULT));
		
		for(Professor professor : result) {
			br.com.spd.model.Professor p = new br.com.spd.model.Professor();
			transformer.transform(professor, p);
			wrapper.getList().add(p);
		}
		
		return wrapper;
	}

	@ResponseBody
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public br.com.spd.model.Professor getOne(@PathVariable final Long id) throws TransformerException {
		Professor result = professorRepository.findOne(id);
		br.com.spd.model.Professor model = new br.com.spd.model.Professor();
		transformer.transform(result, model);
		return model;
	}
	
	@ResponseBody
	@RequestMapping(value="/cpf/{cpf}", method=RequestMethod.GET)
	public br.com.spd.model.Professor getByCPF(@PathVariable final String cpf) throws TransformerException {
		Professor result = professorRepository.findByPessoaCpf(cpf);
		if(result != null){
			br.com.spd.model.Professor model = new br.com.spd.model.Professor();
			transformer.transform(result, model);
			return model;
		}else{
			return null;
		}
		
	}
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.POST)
	public br.com.spd.model.Professor create(@RequestBody br.com.spd.model.Professor professor) throws TransformerException {
		return saveOrUpdate(professor);
	}

	@ResponseBody
	@RequestMapping(method=RequestMethod.PUT)
	public br.com.spd.model.Professor update(@RequestBody br.com.spd.model.Professor professor) throws TransformerException {
		return saveOrUpdate(professor);
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public boolean delete(@PathVariable final Long id) {
		professorRepository.delete(id);
		return professorRepository.findOne(id) == null;
	}
	
	private br.com.spd.model.Professor saveOrUpdate(final br.com.spd.model.Professor professor)
			throws TransformerException {
//		Transform to Domain
		Professor prof = new Professor();
		transformer.transform(professor, prof);
		
//		Save Pessoa and P
		prof = save(prof);
		
//		Transform to Model
		br.com.spd.model.Professor model = new br.com.spd.model.Professor();
		transformer.transform(prof, model);
		
		return model;
	}
	
	private Professor save(Professor professor) {
		Pessoa pessoa = pessoaRepository.save(professor.getPessoa());
		professor.setPessoa(pessoa);
		return professorRepository.save(professor);
	}

}
