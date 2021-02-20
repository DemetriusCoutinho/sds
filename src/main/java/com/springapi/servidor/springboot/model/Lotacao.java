package com.springapi.servidor.springboot.model;

import java.util.Date;

public class Lotacao {
	private String descricao;
	private Date dataLotacao = new Date();
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Date getDataLotacao() {
		return dataLotacao;
	}
	public void setDataLotacao(Date dataLotacao) {
		this.dataLotacao = dataLotacao;
	}
	
	
}
