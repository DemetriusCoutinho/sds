package com.springapi.servidor.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springapi.servidor.springboot.model.Lotacao;

@RestController
public class LotacaoController {

	private List<Lotacao> listLotacao = new ArrayList<Lotacao>();

	@PostMapping("/lotacao")
	public ResponseEntity<String> save(@RequestBody Lotacao lotacao) {
		if (lotacao.getDescricao().isEmpty()) {
			return new ResponseEntity<String>(String.format("Campo Descrição Obrigatório"), HttpStatus.BAD_REQUEST);
		} else {
			this.listLotacao.add(lotacao);
		}
		return new ResponseEntity<String>(String.format("Criado com Sucesso!"), HttpStatus.CREATED);

	}

	@GetMapping("/lotacaoAll")
	public List<Lotacao> getAll() {
		return listLotacao;
	}

}
