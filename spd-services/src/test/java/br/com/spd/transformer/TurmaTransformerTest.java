package br.com.spd.transformer;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.com.spd.domain.TurmaDomainBuilder;
import br.com.spd.exception.TransformerException;
import br.com.spd.model.Turma;
import br.com.spd.model.TurmaModelBuilder;
import br.com.spd.transformer.impl.GenericTransformer;

public class TurmaTransformerTest {
	
	private TurmaModelBuilder turmaModelBuilder;
	private TurmaDomainBuilder turmaDomainBuilder;
	private GenericTransformer transformer;
	
	@Before
	public void setUp() {
		turmaModelBuilder = new TurmaModelBuilder();
		turmaDomainBuilder = new TurmaDomainBuilder();
		transformer = new GenericTransformer();
	}

	@Test
	public void shouldTransformModelToDomain() throws TransformerException {
//		Given
		Turma turma = turmaModelBuilder.build();
		br.com.spd.domain.Turma turmaDomain = new br.com.spd.domain.Turma();
		
//		When
		transformer.transform(turma, turmaDomain);
		
//		Then
		assertEquals(turma.getId(), turmaDomain.getId());
		assertEquals(turma.getDescricao(), turmaDomain.getDescricao());
	}
	
	@Test
	public void shouldTransformDomainToModel() throws TransformerException {
//		Given
		br.com.spd.domain.Turma turma = turmaDomainBuilder.build();
		Turma turmaModel = new Turma();
		
//		When
		transformer.transform(turma, turmaModel);
		
//		Then
		assertEquals(turma.getId(), turmaModel.getId());
		assertEquals(turma.getDescricao(), turmaModel.getDescricao());
	}
	
}
