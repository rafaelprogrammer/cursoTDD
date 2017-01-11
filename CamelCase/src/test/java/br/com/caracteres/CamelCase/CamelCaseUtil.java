package br.com.caracteres.CamelCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
		String[] arrayOriginal = original.replaceAll(String.format("%s|%s|%s", "(?<=[A-Z])(?=[A-Z][a-z])", "(?<=[^A-Z])(?=[A-Z])",
				"(?<=[A-Za-z])(?=[^A-Za-z])"), " ").split(" ");
		for(int i=0;i<arrayOriginal.length;i++){
			arrayOriginal[i] = arrayOriginal[i].substring(0, 1).toLowerCase()+arrayOriginal[i].substring(1);
		}
		return arrayOriginal;
	}

}
