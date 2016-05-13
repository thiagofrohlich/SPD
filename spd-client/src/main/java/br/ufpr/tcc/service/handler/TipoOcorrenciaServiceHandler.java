package br.ufpr.tcc.service.handler;

import br.com.spd.model.Tipo;
import br.com.spd.wrapper.TipoOcorrenciaWrapper;

public interface TipoOcorrenciaServiceHandler extends ServiceHandler<Tipo,Integer>{

	TipoOcorrenciaWrapper getAll();
}
