package br.com.caixaEletronico;

import java.text.NumberFormat;
import java.util.Locale;

public class CaixaEletronico {
	
	private ContaCorrente contaCorrente;

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

	public String sacar(Integer valor) {
		return contaCorrente.getSaldo() > valor ? "Retire seu dinheiro":"Saldo insuficiente";
	}
}
