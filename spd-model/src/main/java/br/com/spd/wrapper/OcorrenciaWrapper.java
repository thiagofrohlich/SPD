package br.com.spd.wrapper;

import org.springframework.data.domain.Page;

import br.com.spd.model.Ocorrencia;

public class OcorrenciaWrapper extends Wrapper<Ocorrencia> {
	
	private static final long serialVersionUID = 1L;

	public OcorrenciaWrapper(Page<? extends Object> page) {
		super(page);
	}

	public OcorrenciaWrapper() {
		super();
	}
	
}
