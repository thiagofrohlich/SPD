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
import br.com.spd.domain.repository.PessoaRepository;
import br.com.spd.exception.TransformerException;
import br.com.spd.wrapper.PessoaWrapper;

public class PessoaControllerTest {

	private PessoaController controller;
	
	@Mock
	private PessoaRepository pessoaRepository;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		controller = new PessoaController(pessoaRepository);
	}
	
	@Test
	public void shouldReturnAllResultsWithWrapper() throws TransformerException {
		List<Pessoa> allList = createListPessoa();
		Page<Pessoa> allPage = new PageImpl<>(allList, null, 3);
		Page<Pessoa> allPageSpy = spy(allPage);
		
		doReturn(1).when(allPageSpy).getNumberOfElements();
		doReturn(3l).when(allPageSpy).getTotalElements();
		doReturn(1).when(allPageSpy).getNumber();
		doReturn(1).when(allPageSpy).getTotalPages();
		
		when(pessoaRepository.findAll(any(PageRequest.class))).thenReturn(allPage);
		
		PessoaWrapper result = controller.getAll(1);
		
		assertNotNull(result);
		verify(pessoaRepository).findAll(any(PageRequest.class));
		verifyNoMoreInteractions(pessoaRepository);
	}

	private List<Pessoa> createListPessoa() {
		List<Pessoa> list = new ArrayList<>();
		list.add(createPessoa(1l));
		list.add(createPessoa(2l));
		list.add(createPessoa(3l));
		return list;
	}
	
	private Pessoa createPessoa(Long codPessoa) {
		Pessoa p = new Pessoa();
		p.setCodpessoa(codPessoa);
		p.setNome("nome-test");
		return p;
	}
	
}
