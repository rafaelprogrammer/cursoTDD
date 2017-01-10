package br.com.caracteres.CamelCase;

import java.util.ArrayList;
import java.util.List;

public class CamelCaseUtil {

	public List<String> converterCamelCase(String original) {
		List<String> list = criarLista(original);
		return list;
	}

	private List<String> criarLista(String original) {
		List<String> list = new ArrayList<String>();
		list.add(original.toLowerCase());
		return list;
	}
	
	/*static String splitCamelCase(String s) {
		   return s.replaceAll(
		      String.format("%s|%s|%s",
		         "(?<=[A-Z])(?=[A-Z][a-z])",
		         "(?<=[^A-Z])(?=[A-Z])",
		         "(?<=[A-Za-z])(?=[^A-Za-z])"
		      ),
		      " "
		   );
		}*/

}
