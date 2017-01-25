package br.com.caixaEletronico;

public interface ServicoRemoto {
	void recuperarConta(String numeroDaConta);
	void persistirConta();
}
