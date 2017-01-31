package br.com.gamificacao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.stream.Collectors;

import org.junit.Test;

import br.com.gamificacao.servico.Armazenamento;
import br.com.gamificacao.servico.Placar;

public class TestePlacarIntegracao {

	@Test
	public void registrarTipoPontoUsuario() {
		Placar placar = new Placar();
		placar.setArmazenamento(new Armazenamento());
		placar.registrar("luta", "estrela", 10);
		assertEquals(10, placar.recuperarPontos("luta", "estrela"));
	}

	@Test
	public void retornarTodosPontosUsuario() {
		Placar placar = new Placar();
		placar.setArmazenamento(new Armazenamento());
		placar.registrar("mario", "estrela", 10);
		placar.registrar("mario", "comentario", 150);
		placar.registrar("mario", "moeda", 0);
		assertNotNull(placar.recuperarTodosPontosUsuario("mario"));
		assertEquals("[mario,comentario,150, mario,estrela,10]", placar.recuperarTodosPontosUsuario("mario").stream()
				.map(m -> m.getUsuario() + "," + m.getTipo() + "," + m.getPontos()).collect(Collectors.toList()).toString());
	}
	
	@Test
	public void retornarRankingTipoPonto() {
		Placar placar = new Placar();
		placar.setArmazenamento(new Armazenamento());
		placar.registrar("super", "topico", 10);
		placar.registrar("power", "topico", 150);
		placar.registrar("java", "topico", 1000);
		placar.registrar("cobol", "topico", 0);
		assertNotNull(placar.recuperarRankingTipoPonto("topico"));
		assertEquals("[java,topico,1000, power,topico,150, super,topico,10]", placar.recuperarRankingTipoPonto("topico").stream()
				.map(m -> m.getUsuario() + "," + m.getTipo() + "," + m.getPontos()).collect(Collectors.toList()).toString());
	}


}
