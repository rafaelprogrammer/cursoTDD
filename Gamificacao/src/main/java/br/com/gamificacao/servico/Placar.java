package br.com.gamificacao.servico;

import java.util.List;

import br.com.gamificacao.model.Usuario;

public class Placar {

	private IArmazenamento armazenamento;
	
	//Registrar um tipo de ponto para um usuário. Por exemplo: o usuário "guerra" recebeu "10" pontos do tipo "estrela"
	public void registrar(String usuario, String tipo, int pontos) {
		armazenamento.salvar(usuario, tipo, pontos);
	}

	public int recuperarPontos(String usuario, String tipo) {
		return armazenamento.recuperarPontos(usuario, tipo);
	}
	
	/* 
	 * Retornar todos os pontos de um usuário. Por exemplo: ao pedir os pontos do usuário "guerra" ele me retornaria 
	 * que possui "20" pontos do tipo "moeda" e "25" pontos do tipo "estrela". Um tipo de ponto que o usuário não possuir, 
	 * não deve ser retornado com valor "0". Por exemplo: se o usuário "guerra" não possui pontos do tipo "energia", 
	 * esses não devem ser incluídos na resposta.
	 */
	public List<Usuario> recuperarTodosPontosUsuario(String usuario) {
		return armazenamento.recuperarTodosPontosUsuario(usuario);
	}

	/*
	* Retornar ranking de um tipo de ponto, com a lista de usuário que possuem aquele ponto ordenados do 
	* que possui mais para o que possui menos. Por exemplo: ao pedir o ranking de "estrela", seria retornado "guerra" com "25", 
	* "fernandes" com "19" e "rodrigo" com "17". Um usuário que não possui pontos daquele tipo não seria incluído no ranking. 
	* Por exemplo, o usuário "toco" sem pontos do tipo "estrela" não seria incluído.
	*/
	public List<Usuario> recuperarRankingTipoPonto(String tipo) {
		return armazenamento.recuperarRankingTipoPonto(tipo);
	}
	
	public IArmazenamento getArmazenamento() {
		return this.armazenamento;
	}

	public void setArmazenamento(IArmazenamento armazenamento) {
		this.armazenamento = armazenamento;
	}
}
