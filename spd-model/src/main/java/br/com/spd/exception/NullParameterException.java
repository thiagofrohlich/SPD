package br.com.spd.exception;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class NullParameterException extends Exception {

	private static final String DEFAULT_MESSAGE = "O parametro passado não pode ser nulo!";
	private static final long serialVersionUID = 1L;
	
	public NullParameterException() {
		super(DEFAULT_MESSAGE);
	}

	public NullParameterException(String message, Throwable exception) {
		super(message, exception);
	}
	
	public NullParameterException(String message) {
		super(message);
	}
	
	public NullParameterException(Throwable exception) {
		super(DEFAULT_MESSAGE, exception);
	}	
	
}
