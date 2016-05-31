package br.ufpr.tcc.service.handler;

import br.com.spd.model.Pessoa;
import br.com.spd.wrapper.ProfessorWrapper;

public interface ProfessorServiceHandler extends ServiceHandler<Pessoa, Integer>{

	ProfessorWrapper findByName(String name);
	
}
