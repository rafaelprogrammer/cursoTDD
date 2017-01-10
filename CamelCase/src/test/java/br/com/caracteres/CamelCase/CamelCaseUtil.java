package br.com.caracteres.CamelCase;

import java.util.ArrayList;
import java.util.List;

public class CamelCaseUtil {

	public List<String> converterCamelCase(String original) {
		List<String> list = new ArrayList<String>();
		list.add(original.toLowerCase());
		return list;
	}

}
