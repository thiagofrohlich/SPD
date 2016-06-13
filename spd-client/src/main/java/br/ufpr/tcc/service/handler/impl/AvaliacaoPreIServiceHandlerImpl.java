package br.ufpr.tcc.service.handler.impl;

import br.com.spd.model.AvaliacaoPre1;
import br.ufpr.tcc.service.handler.AvaliacaoPreIServiceHandler;

public class AvaliacaoPreIServiceHandlerImpl extends AbstractServiceHandler<AvaliacaoPre1, Integer> implements AvaliacaoPreIServiceHandler{

	@Override
	public String getRelativePath() {
		return "/avaliacaoPre1";
	}

}
