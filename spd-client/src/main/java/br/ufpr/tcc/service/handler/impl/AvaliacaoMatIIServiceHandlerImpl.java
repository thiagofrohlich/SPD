package br.ufpr.tcc.service.handler.impl;

import br.com.spd.model.AvaliacaoMat2;
import br.ufpr.tcc.service.handler.AvaliacaoMatIIServiceHandler;

public class AvaliacaoMatIIServiceHandlerImpl extends AbstractServiceHandler<AvaliacaoMat2, Integer> implements AvaliacaoMatIIServiceHandler{

	@Override
	public String getRelativePath() {
		return "/avaliacaoMat2";
	}

}
