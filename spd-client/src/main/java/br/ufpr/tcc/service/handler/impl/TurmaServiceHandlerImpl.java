package br.ufpr.tcc.service.handler.impl;

import br.com.spd.model.Turma;
import br.com.spd.wrapper.TurmaWrapper;
import br.ufpr.tcc.service.handler.TurmaServiceHandler;

public class TurmaServiceHandlerImpl  extends AbstractServiceHandler<Turma,Integer> implements TurmaServiceHandler{

	@Override
	public String getRelativePath() {
		return "/turma";
	}

	@Override
	public TurmaWrapper findAll() {
		return getRestTemplate().getForObject(getPath(), TurmaWrapper.class);
	}

}
