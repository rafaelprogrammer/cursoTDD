package br.com.caracteres.CamelCase;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestConverterCamelCase {
	
	@Test
	public void testConverterNomeSimples(){
		CamelCaseUtil camelCase = new CamelCaseUtil();
		assertEquals(1,camelCase.converterCamelCase("Rafael").size());
		assertEquals("rafael",camelCase.converterCamelCase("Rafael").get(0));
	}
}
