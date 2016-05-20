package br.com.spd.rest;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import br.com.spd.domain.Pessoa;
import br.com.spd.domain.Professor;
import br.com.spd.domain.repository.PessoaRepository;
import br.com.spd.domain.repository.ProfessorRepository;
import br.com.spd.exception.TransformerException;
import br.com.spd.wrapper.ProfessorWrapper;

public class ProfessorControllerTest {

	private ProfessorController controller;
	
	@Mock
	private ProfessorRepository professorRepository;
	private PessoaRepository pessoaRepository;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		controller = new ProfessorController(professorRepository, pessoaRepository);
	}
	
	@Test
	public void shouldReturnAllResultsWithWrapper() throws TransformerException {
		List<Professor> allList = createListProfessor();
		Page<Professor> allPage = new PageImpl<>(allList, null, 3);
		Page<Professor> allPageSpy = spy(allPage);
		
		doReturn(1).when(allPageSpy).getNumberOfElements();
		doReturn(3l).when(allPageSpy).getTotalElements();
		doReturn(1).when(allPageSpy).getNumber();
		doReturn(1).when(allPageSpy).getTotalPages();
		
		when(professorRepository.findAll(any(PageRequest.class))).thenReturn(allPage);
		
		ProfessorWrapper result = controller.getAll(1);
		
		assertNotNull(result);
		verify(professorRepository).findAll(any(PageRequest.class));
		verifyNoMoreInteractions(professorRepository);
	}

	private List<Professor> createListProfessor() {
		List<Professor> list = new ArrayList<>();
		list.add(createProfessor(1l));
		list.add(createProfessor(2l));
		list.add(createProfessor(3l));
		return list;
	}
	
	private Professor createProfessor(Long id) {
		Professor r = new Professor();
		Pessoa pessoa = new Pessoa();
		pessoa.setCodpessoa(id);
		pessoa.setNome("nome-test");
		r.setId(id);
		r.setPessoa(pessoa);
		return r;
	}
	
}
