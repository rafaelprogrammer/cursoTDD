package br.com.gamificacao.repo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.gamificacao.model.Usuario;
/*
 * Classe repositorio que utiliza os recursos do java 8 para armazenar informacoes 
 * em um arquivo.
 */
public class UsuarioRepositorio {

	private static final String CAMINHO_ARQUIVO = "registro.txt";

	public void salvar(Usuario usuario) {
		StringBuilder linhaUsuario = criarLinhaUsuario(usuario);
		if (isNovaLinha(usuario, linhaUsuario)) {
			linhaUsuario.append(recuperarTextoArquivo());
			criarNovaLinha(getPath(), linhaUsuario.toString());
		}
	}

	public Integer recuperarPontosUsuarioPorTipo(Usuario usuario) {
		try {
			Optional<String> result = Files.readAllLines(getPath()).stream()
					.filter(f -> f.contains(usuario.getUsuario()) && f.contains(usuario.getTipo())
							&& converterUsuario(f).getPontos() > 0)
					.findFirst();
			return converterUsuario(result.get()).getPontos();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	public List<String> recuperarTodosTiposDePontosDoUsuario(Usuario usuario) {
		try {
			return Files.readAllLines(getPath()).stream()
					.filter(f -> f.contains(usuario.getUsuario()) && converterUsuario(f).getPontos() > 0)
					.map(m -> converterUsuario(m).getTipo()).collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}

	public List<Usuario> recuperarTodosUsuariosComPontos() {
		try {
			return Files.readAllLines(getPath()).stream().filter(f -> converterUsuario(f).getPontos() > 0)
					.map(m -> converterUsuario(m)).collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}

	public List<Usuario> recuperarTodosPontosUsuario(String usuario) {
		try {
			return Files.readAllLines(getPath()).stream()
					.filter(f -> f.contains(usuario) && converterUsuario(f).getPontos() > 0)
					.map(m -> converterUsuario(m)).collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}

	public List<Usuario> recuperarRankingTipoPonto(String tipo) {
		try {
			return Files.readAllLines(getPath()).stream()
					.filter(f -> f.contains(tipo) && converterUsuario(f).getPontos() > 0)
					.sorted((f1, f2) -> Integer.compare(converterUsuario(f2).getPontos(),
							converterUsuario(f2).getPontos()))
					.map(m -> converterUsuario(m)).collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}

	private String recuperarTextoArquivo() {
		try {
			return new String(Files.readAllBytes(getPath()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Usuario converterUsuario(String txtUsuario) {
		if (txtUsuario != null && !txtUsuario.equals("")) {
			String[] str = txtUsuario.split(",");
			String usuario = str[0].replace("usuario:", "").trim();
			String tipo = str[1].replace("tipo:", "").trim();
			Integer pontos = new Integer(str[2].replace("pontos:", "").trim());
			return new Usuario(usuario, tipo, pontos);
		}
		return new Usuario();
	}

	private StringBuilder criarLinhaUsuario(Usuario usuario) {
		StringBuilder strUsuario = new StringBuilder();
		strUsuario.append("usuario: ").append(usuario.getUsuario());
		strUsuario.append(",").append("tipo: ").append(usuario.getTipo());
		strUsuario.append(",").append("pontos: ").append(usuario.getPontos());
		strUsuario.append("\n");
		return strUsuario;
	}

	private Path getPath() {
		return Paths.get(CAMINHO_ARQUIVO);
	}

	private void criarNovaLinha(Path p, String novaLinha) {
		try {
			Files.write(p, novaLinha.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private boolean isNovaLinha(Usuario usuario, StringBuilder linhaUsuario) {
		String txtArquivo = recuperarTextoArquivo();
		return !txtArquivo.contains(linhaUsuario.toString());
	}

}
