package br.com.spd.transformer;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.InvocationTargetException;

import org.junit.Before;
import org.junit.Test;

import br.com.spd.model.Pessoa;
import br.com.spd.model.PessoaModelBuilder;
import br.com.spd.transformer.impl.GenericTransformer;

public class PessoaTransformerTest {
	
	private PessoaModelBuilder pessoaModelBuilder;
	private GenericTransformer transformer;
	
	@Before
	public void setUp() {
		pessoaModelBuilder = new PessoaModelBuilder();
		transformer = new GenericTransformer();
	}

	@Test
	public void shouldTransformModelToDomain() throws IllegalArgumentException, IllegalAccessException, InstantiationException, InvocationTargetException {
//		Given
		Pessoa pessoa = pessoaModelBuilder.build();
		br.com.spd.domain.Pessoa pessoaDomain = new br.com.spd.domain.Pessoa();
		
//		When
		transformer.transform(pessoa, pessoaDomain);
		
//		Then
		assertEquals(pessoa.getCelular(), pessoaDomain.getCelular());
		assertEquals(pessoa.getCodpessoa(), pessoaDomain.getCodpessoa());
		assertEquals(pessoa.getCpf(), pessoaDomain.getCpf());
		assertEquals(pessoa.getEscolaridade(), pessoaDomain.getEscolaridade());
		assertEquals(pessoa.getLocaltrabalho(), pessoaDomain.getLocaltrabalho());
		assertEquals(pessoa.getNome(), pessoaDomain.getNome());
		assertEquals(pessoa.getParentesco(), pessoaDomain.getParentesco());
		assertEquals(pessoa.getProfissao(), pessoaDomain.getProfissao());
		assertEquals(pessoa.getResponsavel(), pessoaDomain.getResponsavel());
		assertEquals(pessoa.getRg(), pessoaDomain.getRg());
		assertEquals(pessoa.getTelefone(), pessoaDomain.getTelefone());
		assertEquals(pessoa.getAluno(), pessoaDomain.getAluno());
	}
	
}
