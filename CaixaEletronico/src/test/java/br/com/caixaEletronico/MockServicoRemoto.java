package br.com.caixaEletronico;

import static org.junit.Assert.assertEquals;

public class MockServicoRemoto implements ServicoRemoto {
	
	private ContaCorrente contaCorrente;
	private Double valorSaque;
	private Double valorDeposito;
	private Double saldoAnterior;

	@Override
	public  void recuperarConta(String numeroDaConta) {
		contaCorrente = new ContaCorrente(numeroDaConta);
	}

	@Override
	public void persistirConta() {
		verificarPermissaoParaOperacao();
		this.saldoAnterior = contaCorrente.getSaldo();
		if(valorSaque !=null){
			contaCorrente.setSaldo(contaCorrente.getSaldo()-valorSaque);
		}
		if(valorDeposito !=null){
			contaCorrente.setSaldo(contaCorrente.getSaldo()+valorDeposito);
		}
	}

	private void verificarPermissaoParaOperacao() {
		if(valorDeposito == null && valorSaque == null){
			throw new OperacaoNaoAutorizadaException("Esta operação só é permitida para saque ou deposito!");
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

	public ContaCorrente getContaCorrente() {
		return contaCorrente;
	}

}
