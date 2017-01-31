package br.com.gamificacao.servico;

import java.util.List;

import br.com.gamificacao.model.Usuario;
import br.com.gamificacao.repo.UsuarioRepositorio;

public class Armazenamento implements IArmazenamento {

	private UsuarioRepositorio usuarioRepo = new UsuarioRepositorio();

	/* (non-Javadoc)
	 * @see br.com.gamificacao.IArmazenamento#salvar(java.lang.String, java.lang.String, int)
	 */
	@Override
	public void salvar(String usuario, String tipo, int pontos) {
		usuarioRepo.salvar(new Usuario(usuario, tipo, pontos));
	}

	/* (non-Javadoc)
	 * @see br.com.gamificacao.IArmazenamento#recuperarPontos(java.lang.String, java.lang.String)
	 */
	@Override
	public int recuperarPontos(String usuario, String tipo) {
		return usuarioRepo.recuperarPontosUsuarioPorTipo(new Usuario(usuario, tipo, null));
	}

	/* (non-Javadoc)
	 * @see br.com.gamificacao.IArmazenamento#recuperarTodosUsuariosComPontos()
	 */
	@Override
	public List<Usuario> recuperarTodosUsuariosComPontos() {
		return usuarioRepo.recuperarTodosUsuariosComPontos();
	}

	/* (non-Javadoc)
	 * @see br.com.gamificacao.IArmazenamento#recuperarTodosTiposDePontosDoUsuario(java.lang.String)
	 */
	@Override
	public List<String> recuperarTodosTiposDePontosDoUsuario(String usuario) {
		return usuarioRepo.recuperarTodosTiposDePontosDoUsuario(new Usuario(usuario, null, null));
	}

	@Override
	public List<Usuario> recuperarTodosPontosUsuario(String usuario) {
		return usuarioRepo.recuperarTodosPontosUsuario(usuario);
	}

	@Override
	public List<Usuario> recuperarRankingTipoPonto(String tipo) {
		return usuarioRepo.recuperarRankingTipoPonto(tipo);
	}
}
