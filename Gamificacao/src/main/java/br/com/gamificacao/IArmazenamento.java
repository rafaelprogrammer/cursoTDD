package br.com.gamificacao;

import java.util.List;

public interface IArmazenamento {

	void salvar(String usuario, String tipo, int pontos);

	int recuperarPontos(String usuario, String tipo);

	List<Usuario> recuperarTodosUsuariosComPontos();

	List<String> recuperarTodosTiposDePontosDoUsuario(String usuario);

	List<Usuario> recuperarTodosPontosUsuario(String usuario);

	List<Usuario> recuperarRankingTipoPonto(String tipo);

}