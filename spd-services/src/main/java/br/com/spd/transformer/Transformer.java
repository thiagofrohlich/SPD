package br.com.spd.transformer;

import java.lang.reflect.InvocationTargetException;

public interface Transformer {

	void transform(Object objectFrom, Object objectTo) throws IllegalArgumentException, IllegalAccessException, InstantiationException, InvocationTargetException;
	
}
