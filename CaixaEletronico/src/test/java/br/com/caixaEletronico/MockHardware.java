package br.com.caixaEletronico;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MockHardware implements Hardware {
	
	private String numeroContaCartaoRecuperado = "5669693398741223";
	private boolean entregaDinheiro;
	private boolean entregaEnvelope;

	@Override
	public String pegarNumeroDaContaCartao() throws FalhaFuncionamentoException {
		return numeroContaCartaoRecuperado;
	}

	@Override
	public void entregarDinheiro() throws FalhaFuncionamentoException {
		entregaDinheiro = true;
	}

	@Override
	public void lerEnvelope() throws FalhaFuncionamentoException {
		entregaEnvelope = true;
	}

	public void verificarRecuperacaoConta(String numeroContaCartaoEsperado) {
		assertEquals(numeroContaCartaoEsperado, numeroContaCartaoRecuperado);
	}
	
	public void verificarEntregaDinheiro(boolean entregaDinheiroEsperado) {
		assertEquals(entregaDinheiroEsperado, entregaDinheiro);
	}

	public void verificarLeituraEnvelope(boolean entregaEnvelopeEsperado) {
		assertEquals(entregaEnvelopeEsperado, entregaEnvelope);
	}

	public void setEntregaEnvelope(boolean entregaEnvelope) {
		this.entregaEnvelope = entregaEnvelope;
	}
	
	public void setEntregaDinheiro(boolean entregaDinheiro) {
		this.entregaDinheiro = entregaDinheiro;
	}
}
