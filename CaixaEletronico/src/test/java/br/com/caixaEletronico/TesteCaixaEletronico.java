package br.com.caixaEletronico;

import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class TesteCaixaEletronico {
	
	private CaixaEletronico c = new CaixaEletronico();
	private MockServicoRemoto mockServicoRemoto = new MockServicoRemoto();
	private MockHardware mockHardware = new MockHardware();
	
	@Test
	public void loginComSucesso(){
		c.setAcessoContaCorrente(true);
		autenticarNoCaixaEletronico();
		assertEquals("Usuário Autenticado",c.logar());
	}
	
	@Test(expected=FalhaFuncionamentoException.class)
	public void loginComFalhaNaRecuperacaoDoCartao(){
		mockHardware.setFalhaPegarNumeroDaContaCartao(true);
		autenticarNoCaixaEletronico();
	}
	
	@Test
	public void loginComFalhaNaAutenticacao(){
		c.setAcessoContaCorrente(false);
		assertEquals("Não foi possível autenticar o usuário",c.logar());
	}
	
	@Test
	public void recuperarSaldoComSucesso(){
		autenticarNoCaixaEletronico();
		assertEquals("O saldo é R$ 5,00",this.c.saldo());
	}
	
	@Test
	public void sacarComSucesso(){
		autenticarNoCaixaEletronico();
		assertEquals("Retire seu dinheiro",this.c.sacar(3.00));
		mockServicoRemoto.setValorSaque(c.getValorSaque());
		mockServicoRemoto.persistirConta();
		mockServicoRemoto.verificarPersistirConta();
		mockHardware.entregarDinheiro();
		mockHardware.verificarEntregaDinheiro(true);
	}
	
	@Test
	public void sacarComSaldoInsuficiente(){
		autenticarNoCaixaEletronico();
		assertEquals("Saldo insuficiente",this.c.sacar(300.00));
	}
	
	@Test(expected=FalhaFuncionamentoException.class)
	public void sacarComFalhaNaEntregaDoDinheiro(){
		autenticarNoCaixaEletronico();
		assertEquals("Retire seu dinheiro",this.c.sacar(3.00));
		mockServicoRemoto.setValorSaque(c.getValorSaque());
		mockServicoRemoto.persistirConta();
		mockServicoRemoto.verificarPersistirConta();
		mockHardware.setFalhaEntregarDinheiro(true);
		mockHardware.entregarDinheiro();
	}
	
	@Test
	public void depositarComSucesso(){
		autenticarNoCaixaEletronico();
		assertEquals("Depósito recebido com sucesso",this.c.depositar(10.00));
		mockHardware.lerEnvelope();
		mockHardware.verificarLeituraEnvelope(true);
		mockServicoRemoto.setValorDeposito(c.getValorDeposito());
		mockServicoRemoto.persistirConta();
		mockServicoRemoto.verificarPersistirConta();
	}
	
	@Test(expected=FalhaFuncionamentoException.class)
	public void depositarComFalhaAoLerEnvelope(){
		autenticarNoCaixaEletronico();
		assertEquals("Depósito recebido com sucesso",this.c.depositar(10.00));
		mockHardware.setFalhaLerEnvelope(true);
		mockHardware.lerEnvelope();
	}

	private void autenticarNoCaixaEletronico() {
		mockServicoRemoto.recuperarConta(mockHardware.pegarNumeroDaContaCartao());
		mockHardware.verificarRecuperacaoConta("5669693398741223");
		mockServicoRemoto.verificarRecuperaContaCorrente(new ContaCorrente("5669693398741223"));
		c.setValorSaldoAtual(mockServicoRemoto.getContaCorrente().getSaldo());
	}

}
