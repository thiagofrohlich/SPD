package br.ufpr.tcc.service.handler.impl;

import br.com.spd.model.Pessoa;
import br.com.spd.wrapper.ResponsavelWrapper;
import br.ufpr.tcc.service.handler.ResponsavelServiceHandler;

public class ResponsavelServiceHandlerImpl extends AbstractServiceHandler<Pessoa, Integer> implements ResponsavelServiceHandler{

	@Override
	public String getRelativePath() {
		return "/responsavel";
	}

	@Override
	public ResponsavelWrapper findByAluno(Long matricula) {
		return (ResponsavelWrapper) getRestTemplate().getForObject(getPath()+"/aluno/{matricula}", ResponsavelWrapper.class, matricula);
	}

}
