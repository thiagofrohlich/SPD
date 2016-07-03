package br.ufpr.tcc.service.handler;

import br.com.spd.model.Pessoa;
import br.com.spd.wrapper.ResponsavelWrapper;

public interface ResponsavelServiceHandler extends ServiceHandler<Pessoa,Integer>{

	ResponsavelWrapper findByAluno(Long matricula);
	
}
