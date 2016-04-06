package br.com.spd.exception;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TransformerException extends Exception {

	private static final long serialVersionUID = 1L;

	public TransformerException(String message, Exception e) {
		super(message, e);
	}
	
	public TransformerException(Exception e) {
		super(e);
	}

}
