package br.com.gamificacao;

public class Usuario {
	
	private String usuario;
	private String tipo;
	private int pontos;
	
	public Usuario(String usuario, String tipo, int pontos) {
		super();
		this.usuario = usuario;
		this.tipo = tipo;
		this.pontos = pontos;
	}
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getPontos() {
		return pontos;
	}
	public void setPontos(int pontos) {
		this.pontos = pontos;
	}
}
