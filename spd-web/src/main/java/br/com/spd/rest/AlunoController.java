package br.com.spd.rest;

import java.text.SimpleDateFormat;
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
import br.com.spd.domain.TurmaAluno;
import br.com.spd.domain.TurmaAlunoPK;
import br.com.spd.domain.repository.AlunoRepository;
import br.com.spd.domain.repository.TurmaAlunoRepository;
import br.com.spd.exception.TransformerException;
import br.com.spd.transformer.impl.GenericTransformer;
import br.com.spd.wrapper.AlunoWrapper;

@Controller
@RequestMapping("/aluno")
public class AlunoController {
	
	private final AlunoRepository alunoRepository;
	private final TurmaAlunoRepository turmaAlunoRepository;
	private final GenericTransformer transformer;

	@Autowired
	public AlunoController(AlunoRepository alunoRepository, TurmaAlunoRepository turmaAlunoRepository) {
		this.alunoRepository = alunoRepository;
		this.turmaAlunoRepository = turmaAlunoRepository;
		this.transformer = new GenericTransformer();
	}
	
	@ResponseBody
	@RequestMapping(value="/page/{page}", method=RequestMethod.GET)
	public AlunoWrapper getAll(@PathVariable Integer page) throws TransformerException {
		Pageable pageRequest = new PageRequest(page, PageSize.DEFAULT);
		Page<Aluno> result = alunoRepository.findAll(pageRequest);
		AlunoWrapper wrapper = new AlunoWrapper(result);
		wrapper.setList(new ArrayList<br.com.spd.model.Aluno>(PageSize.DEFAULT));
		
		for(Aluno aluno : result) {
			br.com.spd.model.Aluno p = new br.com.spd.model.Aluno();
			transformer.transform(aluno, p);
			wrapper.getList().add(p);
		}
		
		return wrapper;
	}

	@ResponseBody
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public br.com.spd.model.Aluno getOne(@PathVariable final Long id) throws TransformerException {
		Aluno result = alunoRepository.findOne(id);
		br.com.spd.model.Aluno model = new br.com.spd.model.Aluno();
		transformer.transform(result, model);
		return model;
	}
	
	@ResponseBody
	@RequestMapping(value="/nome/{nome}", method=RequestMethod.GET)
	public AlunoWrapper getByNome(@PathVariable String nome) throws TransformerException {
		List<Aluno> result = alunoRepository.findByNomeLike("%"+nome+"%");
		AlunoWrapper wrapper = new AlunoWrapper();
		wrapper.setList(new ArrayList<br.com.spd.model.Aluno>(PageSize.DEFAULT));
		
		for(Aluno aluno : result) {
			br.com.spd.model.Aluno a = new br.com.spd.model.Aluno();
			transformer.transform(aluno, a);
			wrapper.getList().add(a);
		}
		
		return wrapper;
	}
	@ResponseBody
	@RequestMapping(method=RequestMethod.POST)
	public br.com.spd.model.Aluno create(@RequestBody br.com.spd.model.Aluno aluno) throws TransformerException {
		return saveOrUpdate(aluno);
	}

	@ResponseBody
	@RequestMapping(method=RequestMethod.PUT)
	public br.com.spd.model.Aluno update(@RequestBody br.com.spd.model.Aluno aluno) throws TransformerException {
		return saveOrUpdate(aluno);
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public boolean delete(@PathVariable final Long id) {
		alunoRepository.delete(id);
		return alunoRepository.findOne(id) == null;
	}
	
	private br.com.spd.model.Aluno saveOrUpdate(final br.com.spd.model.Aluno aluno)
			throws TransformerException {
		Aluno p = new Aluno();
		transformer.transform(aluno, p);
		p = alunoRepository.save(p);
		br.com.spd.model.Aluno model = new br.com.spd.model.Aluno();
		transformer.transform(p, model);
		saveTurmaAluno(model);
		return model;
	}

	private void saveTurmaAluno(br.com.spd.model.Aluno aluno) {
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY");
		
		TurmaAlunoPK pk = new TurmaAlunoPK();
		pk.setAlunoId(aluno.getMatricula());
		pk.setTurmaId(aluno.getTurma().getId());
		pk.setAno(sdf.format(aluno.getAnoletivo()));
		
		TurmaAluno ta = new TurmaAluno();
		ta.setId(pk);
		
		turmaAlunoRepository.save(ta);
	}

}
