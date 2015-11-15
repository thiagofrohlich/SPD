package br.ufpr.tcc.service.handler;

import java.io.Serializable;

public interface ServiceHandler<M, ID extends Serializable> {

	M getOne(ID id);
	
	M create(M model);
	
	void update(M model);
	
	void delete(ID id);
	
	String getRelativePath();
}
