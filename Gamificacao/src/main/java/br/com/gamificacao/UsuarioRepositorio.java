package br.com.gamificacao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UsuarioRepositorio {

	private static final String CAMINHO_ARQUIVO = "registro.txt";

	public void salvar(Usuario usuario) {
		StringBuilder novoUsuario = criarStringUsuario(usuario);
		if(isNovaLinha(novoUsuario.toString())){
			String textoArquivo = recuperarTextoArquivo();
			criarNovaLinha(getPath(), textoArquivo+=novoUsuario.toString());
		}
	}

	public Integer recuperarPontosUsuarioPorTipo(Usuario usuario) {
		try {
			Optional<String> result = Files.readAllLines(getPath()).stream()
					.filter(f -> f.contains(usuario.getUsuario()) && f.contains(usuario.getTipo())).findFirst();
			return converterUsuario(result.get()).getPontos();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public List<String> recuperarTodosTiposDePontosDoUsuario(Usuario usuario) {
		try {
			return Files.readAllLines(getPath()).stream().filter(f -> f.contains(usuario.getUsuario())).map(m->converterUsuario(m).getTipo()).collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}
	
	public List<Usuario> recuperarTodosUsuariosComPontos() {
		try {
			return Files.readAllLines(getPath()).stream().filter(f -> converterUsuario(f).getPontos() > 0).map(m->converterUsuario(m)).collect(Collectors.toList());
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
		String[] str = txtUsuario.split(",");
		String usuario = str[0].replace("usuario:", "").trim();
		String tipo = str[1].replace("tipo:", "").trim();
		Integer pontos = new Integer(str[2].replace("pontos:", "").trim());
		return new Usuario(usuario, tipo, pontos);
	}

	private StringBuilder criarStringUsuario(Usuario usuario) {
		StringBuilder strUsuario = new StringBuilder();
		strUsuario.append("usuario: ");
		strUsuario.append(usuario.getUsuario());
		strUsuario.append(",");
		strUsuario.append("tipo: ");
		strUsuario.append(usuario.getTipo());
		strUsuario.append(",");
		strUsuario.append("pontos: ");
		strUsuario.append(usuario.getPontos());
		strUsuario.append("\n");
		return strUsuario;
	}

	private Path getPath() {
		return Paths.get(CAMINHO_ARQUIVO);
	}

	private void criarNovaLinha(Path p, String novaLinha) {
		try {
			if(isNovaLinha(novaLinha)){
				Files.write(p, novaLinha.getBytes());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private boolean isNovaLinha(String novaLinha) {
		return !recuperarTextoArquivo().contains(novaLinha);
	}

}
