package com.springapi.servidor.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springapi.servidor.springboot.model.Servidor;

@RestController
public class ServidorController {

	private List<Servidor> listServidor = new ArrayList<Servidor>();

	@PostMapping("/servidor")
	public ResponseEntity<String> save(@RequestBody Servidor servidor) {

		if (servidor.getNome().isEmpty()) {
			return new ResponseEntity<String>(String.format("Campo Nome Obrigatório"), HttpStatus.BAD_REQUEST);
		} else if (servidor.getMatricula().isEmpty()) {
			return new ResponseEntity<String>(String.format("Campo Matricula Obrigatório"), HttpStatus.BAD_REQUEST);
		} else if(servidor.getLotacao() == null){
			return new ResponseEntity<String>(String.format("Adicione uma locacao !"), HttpStatus.BAD_REQUEST);

		}else {
		
			this.listServidor.add(servidor);
		}
		return new ResponseEntity<String>(String.format("Salvo com sucesso!"), HttpStatus.CREATED);

	}

	@GetMapping("/servidor/{matricula}")
	public List<Servidor> getByLotacaoMatricula(@PathVariable String matricula) {
		List<Servidor> listSearchMatricula = new ArrayList<Servidor>();
		this.listServidor.forEach((s) -> {
			if (s.getMatricula().equalsIgnoreCase(matricula)) {
				listSearchMatricula.add(s);
			}
		});

		if (listSearchMatricula.isEmpty()) {
			return null;
		}
		return listSearchMatricula;

	}
	@GetMapping("/servidor/lotacao/{nome}")
	public List<Servidor> getByLotacaoName(@PathVariable String nome) {
		List<Servidor> listSearchNome = new ArrayList<Servidor>();
		this.listServidor.forEach((s) -> {
			if (s.getNome().equalsIgnoreCase(nome)) {
				listSearchNome.add(s);
			}
		});

		if (listSearchNome.isEmpty()) {
			return null;
		}
		return listSearchNome;

	}

	@GetMapping("/servidorAll")
	public List<Servidor> getAllServidores() {
		return listServidor;
	}

}
