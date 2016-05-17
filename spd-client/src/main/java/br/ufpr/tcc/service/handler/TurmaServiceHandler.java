package br.ufpr.tcc.service.handler;

import br.com.spd.model.Turma;
import br.com.spd.wrapper.TurmaWrapper;

public interface TurmaServiceHandler  extends ServiceHandler<Turma, Integer>{

	TurmaWrapper findAll();
}
