package br.ufpr.tcc.service.handler.impl;

import br.com.spd.model.Pessoa;
import br.com.spd.wrapper.ProfessorWrapper;
import br.ufpr.tcc.service.handler.ProfessorServiceHandler;

public class ProfessorServiceHandlerImpl extends AbstractServiceHandler<Pessoa,Integer> implements ProfessorServiceHandler{

	@Override
	public String getRelativePath() {
		return "/professor";
	}

	@Override
	public ProfessorWrapper findByName(String name) {
		return (ProfessorWrapper) getRestTemplate().getForObject(getPath()+"/nome/{nome}", ProfessorWrapper.class, name);
	}

}
