package br.com.caixaEletronico;

public interface Hardware {

	String pegarNumeroDaContaCartao() throws FalhaFuncionamentoException;
	void entregarDinheiro() throws FalhaFuncionamentoException;
	void lerEnvelope() throws FalhaFuncionamentoException;
	
	
	
}
