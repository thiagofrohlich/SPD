package br.ufpr.tcc.service.handler.impl;

import br.com.spd.model.Pessoa;
import br.ufpr.tcc.service.handler.ResponsavelServiceHandler;

public class ResponsavelServiceHandlerImpl extends AbstractServiceHandler<Pessoa, Integer> implements ResponsavelServiceHandler{

	@Override
	public String getRelativePath() {
		return "/responsavel";
	}

}
