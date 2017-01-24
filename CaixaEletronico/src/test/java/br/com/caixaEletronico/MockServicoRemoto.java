package br.com.caixaEletronico;

import static org.junit.Assert.assertEquals;

public class MockServicoRemoto implements ServicoRemoto {
	
	private ContaCorrente contaCorrente;
	private Double valorSaque;
	private Double valorDeposito;
	private Double saldoAnterior;

	@Override
	public  ContaCorrente recuperarConta(String numeroDaConta) {
		contaCorrente = new ContaCorrente(numeroDaConta);
		return contaCorrente;
	}

	@Override
	public void persistirConta() {
		this.saldoAnterior = contaCorrente.getSaldo();
		if(valorSaque !=null){
			contaCorrente.setSaldo(contaCorrente.getSaldo()-valorSaque);
		}
		if(valorDeposito !=null){
			contaCorrente.setSaldo(contaCorrente.getSaldo()+valorDeposito);
		}
	}
	
	public void verificarRecuperaContaCorrente(ContaCorrente contaCorrente){
		assertEquals(contaCorrente.getNumeroDaConta(), contaCorrente.getNumeroDaConta());
	}
	
	public void verificarPersistirConta(){
		if(valorSaque !=null){
			assertEquals(contaCorrente.getSaldo(), new Double(saldoAnterior-valorSaque));
		}
		if(valorDeposito !=null){
			assertEquals(contaCorrente.getSaldo(), new Double(saldoAnterior+valorDeposito));
		}
	}

	public void setValorSaque(Double valorSaque) {
		this.valorSaque = valorSaque;
	}

	public void setValorDeposito(Double valorDeposito) {
		this.valorDeposito = valorDeposito;
	}

}
