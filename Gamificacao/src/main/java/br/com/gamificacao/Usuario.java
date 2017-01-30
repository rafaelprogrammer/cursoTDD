package br.com.gamificacao;

public class Usuario {
	
	private String usuario;
	private String tipo;
	private Integer pontos;
	
	public Usuario(String usuario, String tipo, Integer pontos) {
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
	public Integer getPontos() {
		return pontos;
	}
	public void setPontos(Integer pontos) {
		this.pontos = pontos;
	}
}
