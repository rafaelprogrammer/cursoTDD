package br.com.gamificacao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import br.com.gamificacao.servico.Armazenamento;
import br.com.gamificacao.servico.IArmazenamento;

public class TesteArmazenamento {

	@Test
	public void armazenarUsuario() {
		IArmazenamento armazenamento = new Armazenamento();
		armazenamento.salvar("guerra", "estrela", 10);
		assertEquals(10, armazenamento.recuperarPontos("guerra", "estrela"));
	}
	
	@Test
	public void retornarTodosUsuariosComPontos() {
		IArmazenamento armazenamento = new Armazenamento();
		armazenamento.salvar("estranho", "estrela", 10);
		armazenamento.salvar("selva", "comentario", 5);
		armazenamento.salvar("agoravai", "curtida", 0);
		assertNotNull(armazenamento.recuperarTodosUsuariosComPontos());
	}
	
	@Test
	public void retornarTodosTiposDePontosRegistrados() {
		IArmazenamento armazenamento = new Armazenamento();
		armazenamento.salvar("cavaleiro", "estrela", 10);
		armazenamento.salvar("cavaleiro", "comentario", 5);
		armazenamento.salvar("cavaleiro", "curtida", 60);
		assertNotNull(armazenamento.recuperarTodosTiposDePontosDoUsuario("cavaleiro"));
		assertEquals(3,armazenamento.recuperarTodosTiposDePontosDoUsuario("cavaleiro").size());
		assertArrayEquals(new Object[] { "curtida", "comentario", "estrela" },
				armazenamento.recuperarTodosTiposDePontosDoUsuario("cavaleiro").toArray());
	}
	
	@Test
	public void retornarTodosPontosUsuario() {
		IArmazenamento armazenamento = new Armazenamento();
		armazenamento.salvar("cobra", "estrela", 100);
		armazenamento.salvar("cobra", "moeda", 5);
		armazenamento.salvar("cobra", "curtida", 0);
		assertNotNull(armazenamento.recuperarTodosPontosUsuario("cobra"));
	}

}
