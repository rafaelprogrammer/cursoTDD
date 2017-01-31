package br.com.gamificacao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.stream.Collectors;

import org.junit.Test;

import br.com.gamificacao.mock.MockArmazenamento;
import br.com.gamificacao.servico.Placar;

public class TestePlacar {

	@Test
	public void registrarTipoPontoUsuario() {
		Placar placar = new Placar();
		placar.setArmazenamento(new MockArmazenamento());
		placar.registrar("guerra", "estrela", 10);
		((MockArmazenamento)placar.getArmazenamento()).verificarRegistroSalvo("guerra", "estrela", 10);
		((MockArmazenamento)placar.getArmazenamento()).verificarRecuperaPontos("guerra", "estrela");
		assertEquals(10, placar.recuperarPontos("guerra", "estrela"));
	}

	@Test
	public void retornarTodosPontosUsuario() {
		Placar placar = new Placar();
		placar.setArmazenamento(new MockArmazenamento());
		placar.registrar("guerra", "estrela", 10);
		placar.registrar("guerra", "comentario", 150);
		placar.registrar("guerra", "moeda", 0);
		verificarMockRegistrosTodosPontosUsuario(placar);
		assertNotNull(placar.recuperarTodosPontosUsuario("guerra"));
		assertEquals("[guerra,estrela,10, guerra,comentario,150]", placar.recuperarTodosPontosUsuario("guerra").stream()
				.map(m -> m.getUsuario() + "," + m.getTipo() + "," + m.getPontos()).collect(Collectors.toList()).toString());
	}
	
	@Test
	public void retornarRankingTipoPonto() {
		Placar placar = new Placar();
		placar.setArmazenamento(new MockArmazenamento());
		placar.registrar("guerra", "curtida", 10);
		placar.registrar("selva", "curtida", 150);
		placar.registrar("bruce", "curtida", 1000);
		placar.registrar("programmer", "curtida", 0);
		verificarMockRegistrosRankingTipoPonto(placar);
		assertNotNull(placar.recuperarRankingTipoPonto("curtida"));
		assertEquals("[bruce,curtida,1000, selva,curtida,150, guerra,curtida,10]", placar.recuperarRankingTipoPonto("curtida").stream()
				.map(m -> m.getUsuario() + "," + m.getTipo() + "," + m.getPontos()).collect(Collectors.toList()).toString());
	}

	private void verificarMockRegistrosTodosPontosUsuario(Placar placar) {
		((MockArmazenamento)placar.getArmazenamento()).verificarRegistroSalvo("guerra", "estrela", 10);
		((MockArmazenamento)placar.getArmazenamento()).verificarRegistroSalvo("guerra", "comentario", 150);
		((MockArmazenamento)placar.getArmazenamento()).verificarRegistroSalvo("guerra", "moeda", 0);
		((MockArmazenamento)placar.getArmazenamento()).verificarRecuperaTodosPontosUsuario("[guerra,estrela,10, guerra,comentario,150]","guerra");
	}
	
	private void verificarMockRegistrosRankingTipoPonto(Placar placar) {
		((MockArmazenamento)placar.getArmazenamento()).verificarRegistroSalvo("guerra", "curtida", 10);
		((MockArmazenamento)placar.getArmazenamento()).verificarRegistroSalvo("selva", "curtida", 150);
		((MockArmazenamento)placar.getArmazenamento()).verificarRegistroSalvo("bruce", "curtida", 1000);
		((MockArmazenamento)placar.getArmazenamento()).verificarRegistroSalvo("programmer", "curtida", 0);
		((MockArmazenamento)placar.getArmazenamento()).verificarRecuperaRankingTipoPonto("[bruce,curtida,1000, selva,curtida,150, guerra,curtida,10]", "curtida");
	}

}
