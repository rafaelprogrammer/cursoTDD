package br.com.gamificacao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class TesteArmazenamento {

	// A classe Armazenamento deve ser capaz de realizar as seguintes operações:

	// Armazenar que um usuário recebeu uma quantidade de um tipo de ponto. Por exemplo: o usuário "guerra" recebeu "10" pontos do tipo "estrela"
	// Recuperar quantos pontos de um tipo tem um usuário. Por exemplo: retornar quantos pontos do tipo "estrela" tem o usuário "guerra"
	// Retornar todos os usuários que já receberam algum tipo de ponto.
	// Retornar todos os tipos de ponto que já foram registrados para algum usuário.

	@Test
	public void armazenarUsuario() {
		Armazenamento armazenamento = new Armazenamento();
		armazenamento.salvar("guerra", "estrela", 10);
		assertEquals(10, armazenamento.recuperarPontos("guerra", "estrela"));
	}
	
	@Test
	public void retornarTodosUsuariosComPontos() {
		Armazenamento armazenamento = new Armazenamento();
		armazenamento.salvar("guerra", "estrela", 10);
		armazenamento.salvar("selva", "comentario", 5);
		armazenamento.salvar("agoravai", "curtida", 0);
		assertNotNull(armazenamento.recuperarTodosUsuariosComPontos());
		assertEquals(2,armazenamento.recuperarTodosUsuariosComPontos().size());
	}
	
	@Test
	public void retornarNenhumUsuarioSemPontos() {
		Armazenamento armazenamento = new Armazenamento();
		armazenamento.salvar("guerra", "estrela", 0);
		armazenamento.salvar("selva", "comentario", 0);
		armazenamento.salvar("agoravai", "curtida", 0);
		assertNotNull(armazenamento.recuperarTodosUsuariosComPontos());
		assertEquals(0,armazenamento.recuperarTodosUsuariosComPontos().size());
	}
	
	@Test
	public void retornarTodosTiposDePontosRegistrados() {
		Armazenamento armazenamento = new Armazenamento();
		armazenamento.salvar("guerra", "estrela", 10);
		armazenamento.salvar("guerra", "comentario", 5);
		armazenamento.salvar("guerra", "curtida", 60);
		assertNotNull(armazenamento.recuperarTodosTiposDePontosDoUsuario("guerra"));
		assertEquals(3,armazenamento.recuperarTodosTiposDePontosDoUsuario("guerra").size());
		assertArrayEquals(new Object[] { "estrela", "comentario", "curtida" },
				armazenamento.recuperarTodosTiposDePontosDoUsuario("guerra").toArray());
	}

}
