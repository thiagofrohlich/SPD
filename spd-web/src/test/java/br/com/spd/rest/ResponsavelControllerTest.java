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
import br.com.spd.domain.Responsavel;
import br.com.spd.domain.repository.ResponsavelRepository;
import br.com.spd.exception.TransformerException;
import br.com.spd.wrapper.ResponsavelWrapper;

public class ResponsavelControllerTest {

	private ResponsavelController controller;
	
	@Mock
	private ResponsavelRepository responsavelRepository;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		controller = new ResponsavelController(responsavelRepository);
	}
	
	@Test
	public void shouldReturnAllResultsWithWrapper() throws TransformerException {
		List<Responsavel> allList = createListResponsavel();
		Page<Responsavel> allPage = new PageImpl<>(allList, null, 3);
		Page<Responsavel> allPageSpy = spy(allPage);
		
		doReturn(1).when(allPageSpy).getNumberOfElements();
		doReturn(3l).when(allPageSpy).getTotalElements();
		doReturn(1).when(allPageSpy).getNumber();
		doReturn(1).when(allPageSpy).getTotalPages();
		
		when(responsavelRepository.findAll(any(PageRequest.class))).thenReturn(allPage);
		
		ResponsavelWrapper result = controller.getAll(1);
		
		assertNotNull(result);
		verify(responsavelRepository).findAll(any(PageRequest.class));
		verifyNoMoreInteractions(responsavelRepository);
	}

	private List<Responsavel> createListResponsavel() {
		List<Responsavel> list = new ArrayList<>();
		list.add(createResponsavel(1l));
		list.add(createResponsavel(2l));
		list.add(createResponsavel(3l));
		return list;
	}
	
	private Responsavel createResponsavel(Long id) {
		Responsavel r = new Responsavel();
		Pessoa pessoa = new Pessoa();
		pessoa.setCodpessoa(id);
		pessoa.setNome("nome-test");
		r.setId(id);
		r.setPessoa(pessoa);
		return r;
	}
	
}
