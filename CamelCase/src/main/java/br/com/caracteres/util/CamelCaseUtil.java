package br.com.caracteres.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import br.com.caracteres.exceptions.CadeiaCaracteresObrigatorioException;
import br.com.caracteres.exceptions.CaracteresEspeciaisException;
import br.com.caracteres.exceptions.IniciandoComNumerosException;

public class CamelCaseUtil {

	public List<String> converterCamelCase(String original) {
		List<String> list = criarLista(original);
		return list;
	}

	private List<String> criarLista(String original) {
		List<String> list = new ArrayList<String>();
		list.addAll(Arrays.asList(converter(original)));
		return list;
	}

	private String[] converter(String original) {
		validarCampoObrigatorio(original);
		validarCaracteresEspeciais(original);
		validarInicioComNumeros(original);
		String[] arrayOriginal = original.replaceAll(String.format("%s|%s|%s", "(?<=[A-Z])(?=[A-Z][a-z])", "(?<=[^A-Z])(?=[A-Z])",
				"(?<=[A-Za-z])(?=[^A-Za-z])"), " ").split(" ");
		for(int i=0;i<arrayOriginal.length;i++){
			arrayOriginal[i] = arrayOriginal[i].substring(0, 1).toLowerCase()+arrayOriginal[i].substring(1);
		}
		return arrayOriginal;
	}
	
	private void validarCampoObrigatorio(String original) {
		if(original ==null || original.equals("")){
			throw new CadeiaCaracteresObrigatorioException("É necessário informar a cadeia de caracteres para conversão");
		}
	}

	private void validarInicioComNumeros(String original) {
		if(Character.isDigit(original.charAt(0))){
			throw new IniciandoComNumerosException("Não deve começar com números");
		}
	}

	private void validarCaracteresEspeciais(String original) {
		Pattern patternLetrasENumeros = Pattern.compile("[^A-Za-z0-9]+");
		if(patternLetrasENumeros.matcher(original).find()){
			throw new CaracteresEspeciaisException("Caracteres especiais não são permitidos, somente letras e números");
		}
	}

}
