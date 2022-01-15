package br.com.financas.financas.pessoais.controller;


import java.net.URI;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class ContaControllerTest {


	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testCadastrarComDados() throws Exception {
		URI uri = new URI("/conta");
		String json = "{}";

		mockMvc.perform(MockMvcRequestBuilders.post(uri).content(json).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(201));
	}
	@Test
	public void testCadastrarComDadosIncorreto() throws Exception {
		URI uri = new URI("/conta");
		String json = "{xaxaxaxa}";

		mockMvc.perform(MockMvcRequestBuilders.post(uri).content(json).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(400));
	}

	@Test
	public void testListar() throws Exception {
		URI uri = new URI("/conta");
		String json = "{}";

		mockMvc.perform(MockMvcRequestBuilders.get(uri).content(json).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(200));
	}

	@Test
	public void testDeletar() throws Exception {
		URI uri = new URI("/conta/4");
		String json = "{\"/{id}\"}";

		mockMvc.perform(MockMvcRequestBuilders.delete(uri).content(json).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(200));
	}
	@Test
	public void testDeletarComIdQueNaoExiste() throws Exception {
		URI uri = new URI("/conta/60");
		String json = "{\"/{id}\"}";

		mockMvc.perform(MockMvcRequestBuilders.delete(uri).content(json).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(404));
	}
	@Test
	public void testDeletarSemId() throws Exception {
		URI uri = new URI("/conta/");
		String json = "{\"/{id}\"}";

		mockMvc.perform(MockMvcRequestBuilders.delete(uri).content(json).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(405));
	}
	
	@Test
	public void testPesquisarPorID() throws Exception {
		URI uri = new URI("/conta/10");
		String json = "{\"/{id}\"}";

		mockMvc.perform(MockMvcRequestBuilders.get(uri).content(json).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(200));
	}

	@Test
	public void testModificar() throws Exception {
		URI uri = new URI("/conta/2");
		String json = "{\"saldo\": 1800}";

		mockMvc.perform(MockMvcRequestBuilders.put(uri).content(json).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(200));
	}
	@Test
	public void testModificarSemId() throws Exception {
		URI uri = new URI("/conta/");
		String json = "{\"saldo\": 1800}";

		mockMvc.perform(MockMvcRequestBuilders.put(uri).content(json).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(405));
	}
	@Test
	public void testModificarComIdQueNaoExiste() throws Exception {
		URI uri = new URI("/conta/40");
		String json = "{\"saldo\": 1800}";

		mockMvc.perform(MockMvcRequestBuilders.put(uri).content(json).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(404));
	}
	@Test
	public void testModificarComDadosIncorreto() throws Exception {
		URI uri = new URI("/conta/6");
		String json = "{gagfcx}";

		mockMvc.perform(MockMvcRequestBuilders.put(uri).content(json).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(400));
	}
	
	@Test
	public void testSaldoTotal() throws Exception {
		URI uri = new URI("/conta/soma");
		String json = "{}";

		mockMvc.perform(MockMvcRequestBuilders.get(uri).content(json).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(200));
	}
}
