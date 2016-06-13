package br.ufpr.tcc.service.handler.impl;

import br.com.spd.model.AvaliacaoPre2;
import br.ufpr.tcc.service.handler.AvaliacaoPreIIServiceHandler;

public class AvaliacaoPreIIServiceHandlerImpl extends AbstractServiceHandler<AvaliacaoPre2, Integer> implements AvaliacaoPreIIServiceHandler{

	@Override
	public String getRelativePath() {
		return "/avaliacaoPre2";
	}

}
