package com.springapi.servidor.springboot;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springapi.servidor.springboot.model.Lotacao;
import com.springapi.servidor.springboot.model.Servidor;

@SpringBootTest
@AutoConfigureMockMvc
class ApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMaper;

	@Test
	void case1() {
		Servidor servidor = new Servidor();
		servidor.setNome("");
		servidor.setMatricula("");
		servidor.setLotacao(new Lotacao());
		try {
			mockMvc.perform(
					post("/servidor").contentType("application/json").content(objectMaper.writeValueAsString(servidor)))
					.andExpect(status().isBadRequest());
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void case2() {
		Lotacao lotacao = new Lotacao();
		lotacao.setDescricao("");
		
		try {
			mockMvc.perform(
					post("/lotacao").contentType("application/json").content(objectMaper.writeValueAsString(lotacao)))
					.andExpect(status().isBadRequest());
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
