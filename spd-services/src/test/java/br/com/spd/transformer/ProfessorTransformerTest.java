package br.com.spd.transformer;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.com.spd.domain.Pessoa;
import br.com.spd.domain.PessoaDomainBuilder;
import br.com.spd.domain.ProfessorDomainBuilder;
import br.com.spd.exception.TransformerException;
import br.com.spd.model.Professor;
import br.com.spd.model.ProfessorModelBuilder;
import br.com.spd.transformer.impl.ProfessorTransformer;

public class ProfessorTransformerTest {
	
	private ProfessorModelBuilder professorModelBuilder;
	private ProfessorDomainBuilder professorDomainBuilder;
	private PessoaDomainBuilder pessoaDomainBuilder;
	private ProfessorTransformer transformer;
	
	@Before
	public void setUp() {
		professorModelBuilder = new ProfessorModelBuilder();
		professorDomainBuilder = new ProfessorDomainBuilder();
		pessoaDomainBuilder = new PessoaDomainBuilder();
		transformer = new ProfessorTransformer();
	}

	@Test
	public void shouldTransformModelToDomain() throws TransformerException {
//		Given
		Professor professor = professorModelBuilder.build();
		br.com.spd.domain.Professor professorDomain = new br.com.spd.domain.Professor();
		
//		When
		transformer.transform(professor, professorDomain);
		
//		Then
		assertEquals(professor.getId(), professorDomain.getId());
		assertEquals(professor.getCelular(), professorDomain.getPessoa().getCelular());
		assertEquals(professor.getCodpessoa(), professorDomain.getPessoa().getCodpessoa());
		assertEquals(professor.getCpf(), professorDomain.getPessoa().getCpf());
		assertEquals(professor.getEscolaridade(), professorDomain.getPessoa().getEscolaridade());
		assertEquals(professor.getLocaltrabalho(), professorDomain.getPessoa().getLocaltrabalho());
		assertEquals(professor.getNome(), professorDomain.getPessoa().getNome());
		assertEquals(professor.getProfissao(), professorDomain.getPessoa().getProfissao());
		assertEquals(professor.getRg(), professorDomain.getPessoa().getRg());
		assertEquals(professor.getTelefone(), professorDomain.getPessoa().getTelefone());
		assertEquals(professor.getTurma(), professorDomain.getTurma());
		assertEquals(professor.getCep(), professorDomain.getCep());
		assertEquals(professor.getRua(), professorDomain.getRua());
		assertEquals(professor.getNumero(), professorDomain.getNumero());
		assertEquals(professor.getBairro(), professorDomain.getBairro());
		assertEquals(professor.getCidade(), professorDomain.getCidade());
		assertEquals(professor.getEstado(), professorDomain.getEstado());
		assertEquals(professor.getEmail(), professorDomain.getEmail());
	}
	
	@Test
	public void shouldTransformDomainToModel() throws TransformerException {
//		Given
		Pessoa pessoa = pessoaDomainBuilder.build();
		br.com.spd.domain.Professor professor = professorDomainBuilder.withPessoa(pessoa).build();
		Professor professorModel = new Professor();
		
//		When
		transformer.transform(professor, professorModel);
		
//		Then
		assertEquals(professor.getId(), professorModel.getId());
		assertEquals(professor.getPessoa().getCelular(), professorModel.getCelular());
		assertEquals(professor.getPessoa().getCodpessoa(), professorModel.getCodpessoa());
		assertEquals(professor.getPessoa().getCpf(), professorModel.getCpf());
		assertEquals(professor.getPessoa().getEscolaridade(), professorModel.getEscolaridade());
		assertEquals(professor.getPessoa().getLocaltrabalho(), professorModel.getLocaltrabalho());
		assertEquals(professor.getPessoa().getNome(), professorModel.getNome());
		assertEquals(professor.getPessoa().getProfissao(), professorModel.getProfissao());
		assertEquals(professor.getPessoa().getRg(), professorModel.getRg());
		assertEquals(professor.getPessoa().getTelefone(), professorModel.getTelefone());
		assertEquals(professor.getTurma(), professorModel.getTurma());
		assertEquals(professor.getCep(), professorModel.getCep());
		assertEquals(professor.getRua(), professorModel.getRua());
		assertEquals(professor.getNumero(), professorModel.getNumero());
		assertEquals(professor.getBairro(), professorModel.getBairro());
		assertEquals(professor.getCidade(), professorModel.getCidade());
		assertEquals(professor.getEstado(), professorModel.getEstado());
		assertEquals(professor.getEmail(), professorModel.getEmail());
	}
	
}
