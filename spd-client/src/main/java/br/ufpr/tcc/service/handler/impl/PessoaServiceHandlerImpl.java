package br.ufpr.tcc.service.handler.impl;

import br.com.spd.model.Pessoa;
import br.ufpr.tcc.service.handler.PessoaServiceHandler;

public class PessoaServiceHandlerImpl extends AbstractServiceHandler<Pessoa, Integer> implements PessoaServiceHandler{

	@Override
	public String getRelativePath() {
		return "/pessoa";
	}
}
