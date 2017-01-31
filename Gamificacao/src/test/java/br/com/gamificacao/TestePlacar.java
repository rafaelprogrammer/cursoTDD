package br.com.gamificacao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.stream.Collectors;

import org.junit.Test;

public class TestePlacar {

	// A classe Placar deve ter métodos que executam as seguintes operações:

	// Registrar um tipo de ponto para um usuário. Por exemplo: o usuário
	// "guerra" recebeu "10" pontos do tipo "estrela"

	// Retornar todos os pontos de um usuário. Por exemplo: ao pedir os pontos
	// do usuário "guerra" ele me retornaria que possui "20" pontos do tipo
	// "moeda"
	// e "25" pontos do tipo "estrela". Um tipo de ponto que o usuário não
	// possuir, não deve ser retornado com valor "0". Por exemplo: se o usuário
	// "guerra"
	// não possui pontos do tipo "energia", esses não devem ser incluídos na
	// resposta.

	// Retornar ranking de um tipo de ponto, com a lista de usuário que possuem
	// aquele ponto ordenados do que possui mais para o que possui menos.
	// Por exemplo: ao pedir o ranking de "estrela", seria retornado "guerra"
	// com "25", "fernandes" com "19" e "rodrigo" com "17". Um usuário que não
	// possui pontos daquele tipo não seria incluído no ranking. Por exemplo, o
	// usuário "toco" sem pontos do tipo "estrela" não seria incluído.

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
