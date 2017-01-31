package br.com.gamificacao.mock;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import br.com.gamificacao.model.Usuario;
import br.com.gamificacao.servico.IArmazenamento;

public class MockArmazenamento implements IArmazenamento {

	List<Usuario> usuarios = new ArrayList<>();

	@Override
	public void salvar(String usuario, String tipo, int pontos) {
		usuarios.add(new Usuario(usuario, tipo, pontos));
	}

	@Override
	public int recuperarPontos(String usuario, String tipo) {
		return usuarios.stream().filter(f -> f.getUsuario().equals(usuario) && f.getTipo().equals(tipo) && f.getPontos() > 0)
				.map(m -> m.getPontos()).findFirst().get();
	}

	@Override
	public List<Usuario> recuperarTodosUsuariosComPontos() {
		return null;
	}
	
	@Override
	public List<Usuario> recuperarTodosPontosUsuario(String usuario) {
		return usuarios.stream().filter(f -> f.getUsuario().equals(usuario) && f.getPontos() > 0).collect(Collectors.toList());
	}

	@Override
	public List<String> recuperarTodosTiposDePontosDoUsuario(String usuario) {
		return null;
	}
	
	@Override
	public List<Usuario> recuperarRankingTipoPonto(String tipo) {
		return usuarios.stream().filter(f -> f.getTipo().equals(tipo) && f.getPontos() > 0)
				.sorted((f1, f2) -> Integer.compare(f2.getPontos(), f1.getPontos())).collect(Collectors.toList());
	}

	public void verificarRegistroSalvo(String usuario, String tipo, int pontos) {
		assertNotNull(usuarios.stream().filter(f -> f.getUsuario().equals(usuario)
				&& f.getTipo().equals(tipo) && f.getPontos().equals(pontos)));
	}
	
	public void verificarRecuperaPontos(String usuario, String tipo){
		assertNotNull(usuarios.stream().filter(f -> f.getUsuario().equals(usuario)
				&& f.getTipo().equals(tipo) && f.getPontos() > 0).findFirst().get());
	}
	
	public void verificarRecuperaTodosPontosUsuario(String resultadoEsperado, String usuario){
		assertEquals(resultadoEsperado, usuarios.stream().filter(f -> f.getUsuario().equals(usuario) && f.getPontos() > 0)
				.map(m -> m.getUsuario() + "," + m.getTipo() + "," + m.getPontos()).collect(Collectors.toList()).toString());
	}
	
	public void verificarRecuperaRankingTipoPonto(String resultadoEsperado,String tipo){
		assertEquals(resultadoEsperado, usuarios.stream().filter(f -> f.getTipo().equals(tipo) && f.getPontos() > 0)
				.sorted((f1, f2) -> Integer.compare(f2.getPontos(), f1.getPontos()))
				.map(m -> m.getUsuario() + "," + m.getTipo() + "," + m.getPontos()).collect(Collectors.toList()).toString());
	}
	
}
