package br.com.caixaEletronico;

import java.text.NumberFormat;
import java.util.Locale;

public class CaixaEletronico {
	
	private boolean acessoContaCorrente;
	private Double valorSaldoAtual;
	private Double valorDeposito;
	private Double valorSaque;

	public String logar() {
		return isAcessoContaCorrente()  ? "Usuário Autenticado"
				: "Não foi possível autenticar o usuário";
	}

	public String saldo() {
		return "O saldo é "+NumberFormat.getCurrencyInstance(new Locale("pt", "BR")).format(getValorSaldoAtual());
	}

	public String sacar(Double valorSaque) {
		this.valorSaque = valorSaque;
		return getValorSaldoAtual() > valorSaque ? "Retire seu dinheiro":"Saldo insuficiente";
	}

	public String depositar(Double valorDeposito) {
		this.valorDeposito = valorDeposito;
		return "Depósito recebido com sucesso";
	}

	public Double getValorDeposito() {
		return valorDeposito;
	}

	public void setValorDeposito(Double valorDeposito) {
		this.valorDeposito = valorDeposito;
	}

	public Double getValorSaque() {
		return valorSaque;
	}

	public boolean isAcessoContaCorrente() {
		return acessoContaCorrente;
	}

	public void setAcessoContaCorrente(boolean acessoContaCorrente) {
		this.acessoContaCorrente = acessoContaCorrente;
	}

	public Double getValorSaldoAtual() {
		return valorSaldoAtual;
	}

	public void setValorSaldoAtual(Double valorSaldoAtual) {
		this.valorSaldoAtual = valorSaldoAtual;
	}
}
