package br.com.spd.transformer.impl;

import org.springframework.stereotype.Component;

import br.com.spd.domain.Domain;
import br.com.spd.domain.Pessoa;
import br.com.spd.domain.Responsavel;
import br.com.spd.exception.TransformerException;
import br.com.spd.model.Model;

@Component
public class ResponsavelTransformer extends GenericTransformer {
	
	@Override
	public void transform(Object objectFrom, Object objectTo)
			throws TransformerException {
		
		super.transform(objectFrom, objectTo);
		
		if(instanceOfResponsavel(objectFrom)) {
		
			if(isModel(objectFrom)) {
				transformModelToDomain(objectFrom, objectTo);
			}
			
			if(isDomain(objectFrom)){
				transformDomainToModel(objectFrom, objectTo);
			}
			
		}
		
	}

	private boolean instanceOfResponsavel(Object objectFrom) {
		return Responsavel.class.equals(objectFrom.getClass()) || br.com.spd.model.Responsavel.class.equals(objectFrom.getClass());
	}
	
	private void transformModelToDomain(Object objectFrom, Object objectTo)
			throws TransformerException {
		Responsavel  r = (Responsavel) objectTo;
		Pessoa pessoa = new Pessoa();
		super.transform(objectFrom, pessoa);
		r.setPessoa(pessoa);
	}
	
	private void transformDomainToModel(Object objectFrom, Object objectTo) throws TransformerException {
		Responsavel  r = (Responsavel) objectFrom;
		super.transform(r.getPessoa(), objectTo);
	}

	private boolean isDomain(Object objectFrom) {
		return objectFrom instanceof Domain;
	}
	
	private boolean isModel(Object objectFrom) {
		return objectFrom instanceof Model;
	}	

}
