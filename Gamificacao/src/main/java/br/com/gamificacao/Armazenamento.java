package br.com.gamificacao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Armazenamento {

	private List<Usuario> usuarios = new ArrayList<>();

	public void salvar(String usuario, String tipo, int pontos) {
		usuarios.add(new Usuario(usuario, tipo, pontos));
	}

	public int recuperarPontos(String usuario, String tipo) {
		return usuarios.stream().filter(f -> f.getUsuario().equals(usuario) && f.getTipo().equals(tipo)).findFirst()
				.get().getPontos();
	}

	public List<Usuario> recuperarTodosUsuariosComPontos() {
		return usuarios.stream().filter(f -> f.getPontos() > 0).collect(Collectors.toList());
	}

	public List<String> recuperarTodosTiposDePontosDoUsuario(String usuario) {
		return usuarios.stream().filter(f -> f.getUsuario().equals(usuario)).map(map-> map.getTipo()).collect(Collectors.toList());
	}
}
