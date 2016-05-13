package br.com.spd.transformer;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.com.spd.domain.Pessoa;
import br.com.spd.domain.PessoaDomainBuilder;
import br.com.spd.domain.ResponsavelDomainBuilder;
import br.com.spd.exception.TransformerException;
import br.com.spd.model.Responsavel;
import br.com.spd.model.ResponsavelModelBuilder;
import br.com.spd.transformer.impl.ResponsavelTransformer;

public class ResponsavelTransformerTest {
	
	private ResponsavelModelBuilder responsavelModelBuilder;
	private ResponsavelDomainBuilder responsavelDomainBuilder;
	private PessoaDomainBuilder pessoaDomainBuilder;
	private ResponsavelTransformer transformer;
	
	@Before
	public void setUp() {
		responsavelModelBuilder = new ResponsavelModelBuilder();
		responsavelDomainBuilder = new ResponsavelDomainBuilder();
		pessoaDomainBuilder = new PessoaDomainBuilder();
		transformer = new ResponsavelTransformer();
	}

	@Test
	public void shouldTransformModelToDomain() throws TransformerException {
//		Given
		Responsavel responsavel = responsavelModelBuilder.build();
		br.com.spd.domain.Responsavel responsavelDomain = new br.com.spd.domain.Responsavel();
		
//		When
		transformer.transform(responsavel, responsavelDomain);
		
//		Then
		assertEquals(responsavel.getId(), responsavelDomain.getId());
		assertEquals(responsavel.getCelular(), responsavelDomain.getPessoa().getCelular());
		assertEquals(responsavel.getCodpessoa(), responsavelDomain.getPessoa().getCodpessoa());
		assertEquals(responsavel.getCpf(), responsavelDomain.getPessoa().getCpf());
		assertEquals(responsavel.getEscolaridade(), responsavelDomain.getPessoa().getEscolaridade());
		assertEquals(responsavel.getLocaltrabalho(), responsavelDomain.getPessoa().getLocaltrabalho());
		assertEquals(responsavel.getNome(), responsavelDomain.getPessoa().getNome());
		assertEquals(responsavel.getParentesco(), responsavelDomain.getParentesco());
		assertEquals(responsavel.getProfissao(), responsavelDomain.getPessoa().getProfissao());
		assertEquals(responsavel.getResponsavel(), responsavelDomain.getResponsavel());
		assertEquals(responsavel.getRg(), responsavelDomain.getPessoa().getRg());
		assertEquals(responsavel.getTelefone(), responsavelDomain.getPessoa().getTelefone());
		assertEquals(responsavel.getAluno(), responsavelDomain.getAluno());
	}
	
	@Test
	public void shouldTransformDomainToModel() throws TransformerException {
//		Given
		Pessoa pessoa = pessoaDomainBuilder.build();
		br.com.spd.domain.Responsavel responsavel = responsavelDomainBuilder.withPessoa(pessoa).build();
		Responsavel responsavelModel = new Responsavel();
		
//		When
		transformer.transform(responsavel, responsavelModel);
		
//		Then
		assertEquals(responsavel.getId(), responsavelModel.getId());
		assertEquals(responsavel.getPessoa().getCelular(), responsavelModel.getCelular());
		assertEquals(responsavel.getPessoa().getCodpessoa(), responsavelModel.getCodpessoa());
		assertEquals(responsavel.getPessoa().getCpf(), responsavelModel.getCpf());
		assertEquals(responsavel.getPessoa().getEscolaridade(), responsavelModel.getEscolaridade());
		assertEquals(responsavel.getPessoa().getLocaltrabalho(), responsavelModel.getLocaltrabalho());
		assertEquals(responsavel.getPessoa().getNome(), responsavelModel.getNome());
		assertEquals(responsavel.getParentesco(), responsavelModel.getParentesco());
		assertEquals(responsavel.getPessoa().getProfissao(), responsavelModel.getProfissao());
		assertEquals(responsavel.getResponsavel(), responsavelModel.getResponsavel());
		assertEquals(responsavel.getPessoa().getRg(), responsavelModel.getRg());
		assertEquals(responsavel.getPessoa().getTelefone(), responsavelModel.getTelefone());
		assertEquals(responsavel.getAluno(), responsavelModel.getAluno());
	}
	
}
