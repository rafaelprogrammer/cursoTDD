package br.com.caixaEletronico;

public class ContaCorrente  {

	private String numeroDaConta;
	private Double saldo = 5.00;
	
	public ContaCorrente(String numeroDaConta) {
		super();
		this.numeroDaConta = numeroDaConta;
	}

	public String getNumeroDaConta() {
		return numeroDaConta;
	}

	public void setNumeroDaConta(String numeroDaConta) {
		this.numeroDaConta = numeroDaConta;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
}
