package br.org.serratec.backend.h2banco.exception;

public class EnumValidationException extends Exception{
	
	public static final long serialVersionID = 1L;
	
	public EnumValidationException(String message) {
		super(message);
	}
}
