package br.com.spd.transformer.impl;

import org.springframework.stereotype.Component;

import br.com.spd.domain.Domain;
import br.com.spd.domain.Aluno;
import br.com.spd.exception.TransformerException;
import br.com.spd.model.Model;
import br.com.spd.model.Turma;

@Component
public class AlunoTransformer extends GenericTransformer {
	
	@Override
	public void transform(Object objectFrom, Object objectTo)
			throws TransformerException {
		
		super.transform(objectFrom, objectTo);
		
		if(isInstanceOfAluno(objectFrom)) {
		
			if(isDomain(objectFrom)){
				transformDomainToModel(objectFrom, objectTo);
			}
			
		}
		
	}
	
	private boolean isInstanceOfAluno(Object objectFrom) {
		return Aluno.class.equals(objectFrom.getClass()) || br.com.spd.model.Aluno.class.equals(objectFrom.getClass());
	}

	private void transformDomainToModel(Object objectFrom, Object objectTo) throws TransformerException {
		super.transform(objectFrom, objectTo);
		Aluno alunoDomain = (Aluno) objectFrom;
		Turma turma = new Turma();
		super.transform(alunoDomain.getTurmaAlunos().get(0).getTurma(), turma);
		br.com.spd.model.Aluno alunoModel = (br.com.spd.model.Aluno) objectTo;
		alunoModel.setTurma(turma);
	}

	private boolean isDomain(Object objectFrom) {
		return objectFrom instanceof Domain;
	}
	
	private boolean isModel(Object objectFrom) {
		return objectFrom instanceof Model;
	}	

}
