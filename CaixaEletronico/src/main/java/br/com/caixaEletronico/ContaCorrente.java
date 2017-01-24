package br.com.caixaEletronico;

public class ContaCorrente  {

	private String numeroDaConta;
	private Integer saldo = 5;
	
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

	public Integer getSaldo() {
		return saldo;
	}

	public void setSaldo(Integer saldo) {
		this.saldo = saldo;
	}
}
