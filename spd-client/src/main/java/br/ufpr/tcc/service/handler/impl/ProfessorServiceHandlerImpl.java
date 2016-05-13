package br.ufpr.tcc.service.handler.impl;

import br.com.spd.model.Pessoa;
import br.ufpr.tcc.service.handler.ProfessorServiceHandler;

public class ProfessorServiceHandlerImpl extends AbstractServiceHandler<Pessoa,Integer> implements ProfessorServiceHandler{

	@Override
	public String getRelativePath() {
		return "/professor";
	}

}
