package br.com.caixaEletronico;

public interface ServicoRemoto {
	ContaCorrente recuperarConta(String numeroDaConta);
	void persistirConta();
}
