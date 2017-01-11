package br.com.caracteres.exceptions;

public class CadeiaCaracteresObrigatorioException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public CadeiaCaracteresObrigatorioException(String msg) {
		super(msg);
	}
	
}
