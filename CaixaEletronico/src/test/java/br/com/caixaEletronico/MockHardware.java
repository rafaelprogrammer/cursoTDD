package br.com.caixaEletronico;

import static org.junit.Assert.assertEquals;

public class MockHardware implements Hardware {
	
	private String numeroContaCartaoRecuperado = "5669693398741223";
	private boolean entregaDinheiro;
	private boolean entregaEnvelope;
	private boolean falhaPegarNumeroDaContaCartao;
	private boolean falhaEntregarDinheiro;
	private boolean falhaLerEnvelope;

	@Override
	public String pegarNumeroDaContaCartao() throws FalhaFuncionamentoException {
		if(this.falhaPegarNumeroDaContaCartao){
			throw new FalhaFuncionamentoException("Falha ao ler o número da conta do cartão!");
		}
		return this.numeroContaCartaoRecuperado;
	}

	@Override
	public void entregarDinheiro() throws FalhaFuncionamentoException {
		if(this.falhaEntregarDinheiro){
			throw new FalhaFuncionamentoException("Falha para entregar o dinheiro!");
		}
		this.entregaDinheiro = true;
	}

	@Override
	public void lerEnvelope() throws FalhaFuncionamentoException {
		if(this.falhaLerEnvelope){
			throw new FalhaFuncionamentoException("Falha ao ler o envelope!");
		}
		this.entregaEnvelope = true;
	}

	public void verificarRecuperacaoConta(String numeroContaCartaoEsperado) {
		assertEquals(numeroContaCartaoEsperado, this.numeroContaCartaoRecuperado);
	}
	
	public void verificarEntregaDinheiro(boolean entregaDinheiroEsperado) {
		assertEquals(entregaDinheiroEsperado, this.entregaDinheiro);
	}

	public void verificarLeituraEnvelope(boolean entregaEnvelopeEsperado) {
		assertEquals(entregaEnvelopeEsperado, this.entregaEnvelope);
	}

	public void setEntregaEnvelope(boolean entregaEnvelope) {
		this.entregaEnvelope = entregaEnvelope;
	}
	
	public void setEntregaDinheiro(boolean entregaDinheiro) {
		this.entregaDinheiro = entregaDinheiro;
	}

	public void setFalhaPegarNumeroDaContaCartao(boolean falhaPegarNumeroDaContaCartao) {
		this.falhaPegarNumeroDaContaCartao = falhaPegarNumeroDaContaCartao;
	}

	public void setFalhaEntregarDinheiro(boolean falhaEntregarDinheiro) {
		this.falhaEntregarDinheiro = falhaEntregarDinheiro;
	}

	public void setFalhaLerEnvelope(boolean falhaLerEnvelope) {
		this.falhaLerEnvelope = falhaLerEnvelope;
	}
}
