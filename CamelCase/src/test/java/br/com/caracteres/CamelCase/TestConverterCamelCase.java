package br.com.caracteres.CamelCase;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestConverterCamelCase {
	
	@Test
	public void testConverterNomeSimples(){
		CamelCaseUtil camelCase = new CamelCaseUtil();
		assertEquals(1,camelCase.converterCamelCase("Rafael").size());
		assertEquals("rafael",camelCase.converterCamelCase("Rafael").get(0));
	}
	
	@Test
	public void testConverterNomeComposto(){
		CamelCaseUtil camelCase = new CamelCaseUtil();
		assertEquals(2,camelCase.converterCamelCase("RafaelAlves").size());
		assertArrayEquals(new Object[]{"rafael","alves"}, camelCase.converterCamelCase("RafaelAlves").toArray());
	}
	
	@Test
	public void testConverterCadeiaCaracteresComNumeros(){
		CamelCaseUtil camelCase = new CamelCaseUtil();
		assertEquals(3,camelCase.converterCamelCase("Rafael11Alves").size());
		assertArrayEquals(new Object[]{"rafael","11","alves"}, camelCase.converterCamelCase("Rafael11Alves").toArray());
	}
}
