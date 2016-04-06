package br.com.spd.transformer;

import br.com.spd.exception.TransformerException;

public interface Transformer {

	void transform(Object objectFrom, Object objectTo) throws TransformerException;
	
}
