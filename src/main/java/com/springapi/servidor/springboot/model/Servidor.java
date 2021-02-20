package com.springapi.servidor.springboot.model;

import java.util.Date;

import org.springframework.beans.factory.annotation.Required;

public class Servidor {
	private String nome;
	private  String matricula;
	private Date dataServidor ;
	private Lotacao lotacao;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public Date getDataServidor() {
		if(this.dataServidor == null) {
			this.dataServidor = new Date();
		}
		return dataServidor;
	}
	public void setDataServidor(Date dataServidor) {
		this.dataServidor = dataServidor;
	}
	public Lotacao getLotacao() {
		return lotacao;
	}
	public void setLotacao(Lotacao lotacao) {
		this.lotacao = lotacao;
	}
	

}
