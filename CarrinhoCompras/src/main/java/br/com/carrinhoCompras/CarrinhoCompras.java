package br.com.carrinhoCompras;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoCompras {

	private List<Produto> itens = new ArrayList<>();
	private List<ObservadorCarrinho> observadores = new ArrayList<>();
	
	public void adicionaProduto(Produto p) {
		itens.add(p);

		for (ObservadorCarrinho observador : observadores) {
			try {
				observador.produtoAdicionado(p.getNome(), p.getValor());
			} catch (Exception e) {

			}
		}

	}
	
	public int total(){
		int total = 0;
		for(Produto p: itens){
			total += p.getValor();
		}
		return total;
	}

	public void adicionaObservador(ObservadorCarrinho observador) {
		this.observadores.add(observador);
	}
	
}
