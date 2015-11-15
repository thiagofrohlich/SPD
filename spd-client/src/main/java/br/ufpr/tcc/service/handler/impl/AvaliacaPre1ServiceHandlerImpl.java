package br.ufpr.tcc.service.handler.impl;

import br.com.spd.model.AvaliacaoPre1;
import br.ufpr.tcc.service.handler.AvaliacaoPreIServiceHandler;

public class AvaliacaPre1ServiceHandlerImpl extends AbstractServiceHandler<AvaliacaoPre1, Integer> implements AvaliacaoPreIServiceHandler{

	@Override
	public String getRelativePath() {
		return "/avaliacaPreI";
	}

}
