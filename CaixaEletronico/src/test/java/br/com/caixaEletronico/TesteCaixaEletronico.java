package br.com.caixaEletronico;

import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class TesteCaixaEletronico {
	
	private CaixaEletronico c;
	
	@Test
	public void loginComSucesso(){
		AutenticarNoCaixaEletronico();
	}
	
	@Test
	public void loginComFalha(){
		CaixaEletronico c = new CaixaEletronico();
		c.setContaCorrente(null);
		assertEquals("Não foi possível autenticar o usuário",c.logar());
	}
	
	@Test(expected = FalhaFuncionamentoException.class)
	public void recuperaNumeroDaContaCartaoComFalha(){
		MockHardwareComFalha mock = new MockHardwareComFalha();
		mock.pegarNumeroDaContaCartao();
	}
	
	@Test
	public void recuperaSaldoComSucesso(){
		AutenticarNoCaixaEletronico();
		assertEquals("O saldo é R$ 5,00",c.saldo());
	}
	
	@Test
	public void sacarComSucesso(){
		AutenticarNoCaixaEletronico();
		assertEquals("Retire seu dinheiro",c.sacar(3));
	}

	private void AutenticarNoCaixaEletronico() {
		c = new CaixaEletronico();
		MockHardware mock = new MockHardware();
		MockServicoRemoto mockServicoRemoto = new MockServicoRemoto();
		c.setContaCorrente(mockServicoRemoto.recuperarConta(mock.pegarNumeroDaContaCartao()));
		mock.verificarNumeroContaCartao("5669693398741223");
		mockServicoRemoto.verificarRecuperaContaCorrente(new ContaCorrente("5669693398741223"));
		assertEquals("Usuário Autenticado",c.logar());
	}

}
