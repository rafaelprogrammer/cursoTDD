package br.com.gamificacao.servico;

import java.util.List;

import br.com.gamificacao.model.Usuario;

public interface IArmazenamento {

	
	/* Armazenar que um usuário recebeu uma quantidade de um tipo de ponto.
	 * Por exemplo: o usuário "guerra" recebeu "10" pontos do tipo "estrela"
	*/
	void salvar(String usuario, String tipo, int pontos);

	/*
	* Recuperar quantos pontos de um tipo tem um usuário. Por exemplo: 
	* retornar quantos pontos do tipo "estrela" tem o usuário "guerra"
	* 
	*/
	int recuperarPontos(String usuario, String tipo);

	//Retornar todos os usuários que já receberam algum tipo de ponto
	List<Usuario> recuperarTodosUsuariosComPontos();

	//Retornar todos os tipos de ponto que já foram registrados para algum usuário.
	List<String> recuperarTodosTiposDePontosDoUsuario(String usuario);

	List<Usuario> recuperarTodosPontosUsuario(String usuario);

	List<Usuario> recuperarRankingTipoPonto(String tipo);

}