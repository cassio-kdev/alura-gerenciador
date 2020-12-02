package br.com.kdev.gerenciador.modelo;

import java.util.Date;

public class Empresa {

	
	private String nome;
	private Integer id=0;
	private Date dataAbertura = new Date();

	public Empresa() {}
	public Empresa(Integer id) {
		this.id = id;
	}
	public Empresa(Integer id, String nome, Date dataAbertura) {
		this.id = id;
		this.nome = nome;
		this.dataAbertura = dataAbertura;
	}
	public Empresa(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getId() {
		return id;
	}
	public Date getDataAbertura() {
		return dataAbertura;
	}
	
	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
	@Override
	public String toString() {
		return "Empresa [nome=" + nome + ", id=" + id + ", dataAbertura=" + dataAbertura + "]";
	}
}
