package br.ufpr.tcc.service.handler.impl;

import br.com.spd.model.Ocorrencia;
import br.ufpr.tcc.service.handler.OcorrenciaServiceHandler;

public class OcorrenciaServiceHandlerImpl extends AbstractServiceHandler<Ocorrencia, Integer> implements OcorrenciaServiceHandler{

	@Override
	public String getRelativePath() {
		return "/ocorrencia";
	}

}
