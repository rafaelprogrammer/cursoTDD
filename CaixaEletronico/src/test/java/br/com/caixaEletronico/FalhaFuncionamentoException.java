package br.com.caixaEletronico;

public class FalhaFuncionamentoException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public FalhaFuncionamentoException(String msg) {
		super(msg);
	}

}
