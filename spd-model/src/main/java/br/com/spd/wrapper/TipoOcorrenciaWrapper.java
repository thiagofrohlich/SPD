package br.com.spd.wrapper;

import org.springframework.data.domain.Page;

import br.com.spd.model.TipoOcorrencia;

public class TipoOcorrenciaWrapper extends Wrapper<TipoOcorrencia> {
	
	private static final long serialVersionUID = 1L;

	public TipoOcorrenciaWrapper(Page<? extends Object> page) {
		super(page);
	}

	public TipoOcorrenciaWrapper() {
		super();
	}
	
}
