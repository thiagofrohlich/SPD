package br.ufpr.tcc.service.handler.impl;

import br.com.spd.model.Tipo;
import br.com.spd.wrapper.TipoOcorrenciaWrapper;
import br.ufpr.tcc.service.handler.TipoOcorrenciaServiceHandler;

public class TipoOcorrenciaServiceHandlerImpl extends AbstractServiceHandler<Tipo, Integer> implements TipoOcorrenciaServiceHandler{

	@Override
	public String getRelativePath() {
		return "/tipoOcorrencia";
	}

	@Override
	public TipoOcorrenciaWrapper getAll() {
		return getRestTemplate().getForObject(getPath(), TipoOcorrenciaWrapper.class);
	}

}
