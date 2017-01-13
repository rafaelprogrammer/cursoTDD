package br.com.tradutor;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TesteTradutor {
	
	private Tradutor t;
	
	@Before
	public void criarTradutor(){
		t = new Tradutor();
	}

	@Test
	public void tradutorSemPalavras() {
		t = new Tradutor();
		assertTrue(t.estaVazio());
	}
	
	@Test
	public void umaTraducao() {
		t = new Tradutor();
		t.adicionaTraducao("bom","good");
		assertFalse(t.estaVazio());
		assertEquals("good",t.traduzir("bom"));
	}
	
	@Test
	public void duasTraducoes() {
		t = new Tradutor();
		t.adicionaTraducao("bom","good");
		t.adicionaTraducao("mal","bad");
		assertEquals("good",t.traduzir("bom"));
		assertEquals("bad",t.traduzir("mal"));
	}
	

}
