package br.com.caixaEletronico;

public class MockHardwareComFalha implements Hardware {
	
	@Override
	public String pegarNumeroDaContaCartao() throws FalhaFuncionamentoException {
		throw new FalhaFuncionamentoException("Falha ao ler o número da conta do cartão!");
	}

	@Override
	public void entregarDinheiro() throws FalhaFuncionamentoException {

	}

	@Override
	public void lerEnvelope() throws FalhaFuncionamentoException {

	}
}
