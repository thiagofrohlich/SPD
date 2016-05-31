package br.ufpr.tcc.service.handler;

public interface RelatorioServiceHandler extends ServiceHandler<Integer, Integer>{

	String getRelativePath();

	byte[] getTeste();
}
