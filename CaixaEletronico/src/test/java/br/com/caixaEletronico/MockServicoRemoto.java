package br.com.caixaEletronico;

import static org.junit.Assert.assertEquals;

public class MockServicoRemoto implements ServicoRemoto {
	
	private ContaCorrente contaCorrente;

	@Override
	public  ContaCorrente recuperarConta(String numeroDaConta) {
		contaCorrente = new ContaCorrente(numeroDaConta);
		return contaCorrente;
	}

	@Override
	public void persistirConta() {
	}
	
	public void verificarRecuperaContaCorrente(ContaCorrente contaCorrente){
		assertEquals(contaCorrente.getNumeroDaConta(), contaCorrente.getNumeroDaConta());
	}

}
