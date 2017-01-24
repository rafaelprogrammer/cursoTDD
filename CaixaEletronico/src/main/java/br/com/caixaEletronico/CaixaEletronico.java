package br.com.caixaEletronico;

import java.text.NumberFormat;
import java.util.Locale;

public class CaixaEletronico {
	
	private ContaCorrente contaCorrente;
	private Double valorDeposito;
	private Double valorSaque;

	public String logar() {
		return contaCorrente != null && contaCorrente.getNumeroDaConta() != null ? "Usuário Autenticado"
				: "Não foi possível autenticar o usuário";
	}

	public void setContaCorrente(ContaCorrente contaCorrente) {
		this.contaCorrente = contaCorrente;
	}

	public String saldo() {
		return "O saldo é "+NumberFormat.getCurrencyInstance(new Locale("pt", "BR")).format(contaCorrente.getSaldo());
	}

	public String sacar(Double valorSaque) {
		this.valorSaque = valorSaque;
		return contaCorrente.getSaldo() > valorSaque ? "Retire seu dinheiro":"Saldo insuficiente";
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
}
