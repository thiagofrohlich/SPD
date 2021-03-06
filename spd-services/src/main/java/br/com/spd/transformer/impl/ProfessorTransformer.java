package br.com.spd.transformer.impl;

import org.springframework.stereotype.Component;

import br.com.spd.domain.Domain;
import br.com.spd.domain.Pessoa;
import br.com.spd.domain.Professor;
import br.com.spd.exception.TransformerException;
import br.com.spd.model.Model;

@Component
public class ProfessorTransformer extends GenericTransformer {
	
	@Override
	public void transform(Object objectFrom, Object objectTo)
			throws TransformerException {
		
		super.transform(objectFrom, objectTo);
		
		if(isInstanceOfProfessor(objectFrom)) {
		
			if(isModel(objectFrom)) {
				transformModelToDomain(objectFrom, objectTo);
			}
			
			if(isDomain(objectFrom)){
				transformDomainToModel(objectFrom, objectTo);
			}
			
		}
		
	}
	
	private boolean isInstanceOfProfessor(Object objectFrom) {
		return Professor.class.equals(objectFrom.getClass()) || br.com.spd.model.Professor.class.equals(objectFrom.getClass());
	}

	private void transformModelToDomain(Object objectFrom, Object objectTo)
			throws TransformerException {
		Professor  r = (Professor) objectTo;
		Pessoa pessoa = new Pessoa();
		super.transform(objectFrom, pessoa);
		r.setPessoa(pessoa);
	}
	
	private void transformDomainToModel(Object objectFrom, Object objectTo) throws TransformerException {
		Professor  r = (Professor) objectFrom;
		super.transform(r.getPessoa(), objectTo);
	}

	private boolean isDomain(Object objectFrom) {
		return objectFrom instanceof Domain;
	}
	
	private boolean isModel(Object objectFrom) {
		return objectFrom instanceof Model;
	}	

}
