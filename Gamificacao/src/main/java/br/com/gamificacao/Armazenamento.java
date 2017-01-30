package br.com.gamificacao;

import java.util.List;

public class Armazenamento {

	private UsuarioRepo usuarioRepo = new UsuarioRepo();

	public void salvar(String usuario, String tipo, int pontos) {
		usuarioRepo.salvar(new Usuario(usuario, tipo, pontos));
	}

	public int recuperarPontos(String usuario, String tipo) {
		return usuarioRepo.recuperarPontosUsuarioPorTipo(new Usuario(usuario, tipo, null));
	}

	public List<Usuario> recuperarTodosUsuariosComPontos() {
		return usuarioRepo.recuperarTodosUsuariosComPontos();
	}

	public List<String> recuperarTodosTiposDePontosDoUsuario(String usuario) {
		return usuarioRepo.recuperarTodosTiposDePontosDoUsuario(new Usuario(usuario, null, null));
	}
}
