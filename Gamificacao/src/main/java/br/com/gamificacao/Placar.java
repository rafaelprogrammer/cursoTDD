package br.com.gamificacao;

import java.util.List;

public class Placar {

	private IArmazenamento armazenamento;
	
	public void registrar(String usuario, String tipo, int pontos) {
		armazenamento.salvar(usuario, tipo, pontos);
	}

	public int recuperarPontos(String usuario, String tipo) {
		return armazenamento.recuperarPontos(usuario, tipo);
	}
	
	public List<Usuario> recuperarTodosPontosUsuario(String usuario) {
		return armazenamento.recuperarTodosPontosUsuario(usuario);
	}

	public IArmazenamento getArmazenamento() {
		return this.armazenamento;
	}

	public void setArmazenamento(IArmazenamento armazenamento) {
		this.armazenamento = armazenamento;
	}

	public List<Usuario> recuperarRankingTipoPonto(String tipo) {
		return armazenamento.recuperarRankingTipoPonto(tipo);
	}
}
