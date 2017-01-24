package br.com.caixaEletronico;

import static org.junit.Assert.assertEquals;

public class MockHardware implements Hardware {
	
	private String numeroContaCartaoRecuperado = "5669693398741223";

	@Override
	public String pegarNumeroDaContaCartao() throws FalhaFuncionamentoException {
		return numeroContaCartaoRecuperado;
	}

	@Override
	public void entregarDinheiro() throws FalhaFuncionamentoException {

	}

	@Override
	public void lerEnvelope() throws FalhaFuncionamentoException {

	}

	public void verificarNumeroContaCartao(String numeroContaCartaoEsperado) {
		assertEquals(numeroContaCartaoEsperado, numeroContaCartaoRecuperado);
	}

}
