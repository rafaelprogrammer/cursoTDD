package br.com.caixaEletronico;

import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class TesteCaixaEletronico {
	
	private CaixaEletronico c;
	private MockServicoRemoto mockServicoRemoto;
	private MockHardware mockHardware;
	
	@Test
	public void loginComSucesso(){
		AutenticarNoCaixaEletronico();
	}
	
	@Test
	public void loginComFalha(){
		this.c = new CaixaEletronico();
		this.c.setContaCorrente(null);
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
		assertEquals("O saldo é R$ 5,00",this.c.saldo());
	}
	
	@Test
	public void sacarComSucesso(){
		AutenticarNoCaixaEletronico();
		assertEquals("Retire seu dinheiro",this.c.sacar(3.00));
		mockServicoRemoto.setValorSaque(c.getValorSaque());
		mockServicoRemoto.persistirConta();
		mockServicoRemoto.verificarPersistirConta();
		mockHardware.entregarDinheiro();
		mockHardware.verificarEntregaDinheiro(true);
	}
	
	@Test
	public void depositarComSucesso(){
		AutenticarNoCaixaEletronico();
		assertEquals("Depósito recebido com sucesso",this.c.depositar(10.00));
		mockHardware.lerEnvelope();
		mockHardware.verificarLeituraEnvelope(true);
		mockServicoRemoto.setValorDeposito(c.getValorDeposito());
		mockServicoRemoto.persistirConta();
		mockServicoRemoto.verificarPersistirConta();
	}

	private void AutenticarNoCaixaEletronico() {
		this.c = new CaixaEletronico();
		mockHardware = new MockHardware();
		this.mockServicoRemoto = new MockServicoRemoto();
		this.c.setContaCorrente(mockServicoRemoto.recuperarConta(mockHardware.pegarNumeroDaContaCartao()));
		mockHardware.verificarNumeroContaCartao("5669693398741223");
		mockServicoRemoto.verificarRecuperaContaCorrente(new ContaCorrente("5669693398741223"));
		assertEquals("Usuário Autenticado",c.logar());
	}

}
