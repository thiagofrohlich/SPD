package br.ufpr.tcc.service.handler.impl;

import br.ufpr.tcc.service.handler.RelatorioServiceHandler;

public class RelatorioServiceHandlerImpl extends AbstractServiceHandler<Integer, Integer> implements RelatorioServiceHandler {
	
	
	@Override
	public String getRelativePath() {
		return "/relatorio";
	}
	
	@Override
	public byte[] getTeste() {
		return   getRestTemplate().getForObject(getPath()+"/test", byte[].class);
	}
	
	
	
	
	
	
	
	
}
