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
public class ReceitaControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testCadastrarComDados() throws Exception {
		URI uri = new URI("/receita");
		String json = "{}";

		mockMvc.perform(MockMvcRequestBuilders.post(uri).content(json).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(201));
	}

	@Test
	public void testCadastrarComDadosIncorreto() throws Exception {
		URI uri = new URI("/receita");
		String json = "{avwqqwdwqa}";

		mockMvc.perform(MockMvcRequestBuilders.post(uri).content(json).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(400));
	}

	@Test
	public void testListar() throws Exception {
		URI uri = new URI("/receita");
		String json = "{}";

		mockMvc.perform(MockMvcRequestBuilders.get(uri).content(json).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(200));
	}

	@Test
	public void testDeletar() throws Exception {
		URI uri = new URI("/receita/1");
		String json = "{\"/{id}\"}";

		mockMvc.perform(MockMvcRequestBuilders.delete(uri).content(json).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(200));
	}

	@Test
	public void testDeletarComIdQueNaoExiste() throws Exception {
		URI uri = new URI("/receita/80");
		String json = "{\"/{id}\"}";

		mockMvc.perform(MockMvcRequestBuilders.delete(uri).content(json).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(404));
	}

	@Test
	public void testDeletarSemID() throws Exception {
		URI uri = new URI("/receita");
		String json = "{\"/{id}\"}";

		mockMvc.perform(MockMvcRequestBuilders.delete(uri).content(json).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(405));
	}

	@Test
	public void testPesquisarPorID() throws Exception {
		URI uri = new URI("/receita/2");
		String json = "{\"/{id}\"}";

		mockMvc.perform(MockMvcRequestBuilders.get(uri).content(json).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(200));
	}

	@Test
	public void testPesquisarPorIDQueNaoExISTE() throws Exception {
		URI uri = new URI("/receita/81");
		String json = "{\"/{id}\"}";

		mockMvc.perform(MockMvcRequestBuilders.get(uri).content(json).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(404));
	}

	@Test
	public void testModificar() throws Exception {
		URI uri = new URI("/receita/2");
		String json = "{	\"valor\": 350.00,\r\n" + "		\"descricao\": \"aumentou o preço\"}";

		mockMvc.perform(MockMvcRequestBuilders.put(uri).content(json).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(200));
	}

	@Test
	public void testModificarIdQueNaoExiste() throws Exception {
		URI uri = new URI("/receita/81");
		String json = "{	\"valor\": 350.00,\r\n" + "		\"descricao\": \"aumentou o preço\"}";

		mockMvc.perform(MockMvcRequestBuilders.put(uri).content(json).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(404));
	}

	@Test
	public void testModificarSemID() throws Exception {
		URI uri = new URI("/receita/");
		String json = "{	\"valor\": 350.00,\r\n" + "		\"descricao\": \"aumentou o preço\"}";

		mockMvc.perform(MockMvcRequestBuilders.put(uri).content(json).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(405));
	}

	@Test
	public void testModificarComDadosIncorreto() throws Exception {
		URI uri = new URI("/receita/2");
		String json = "{fadasddda}";

		mockMvc.perform(MockMvcRequestBuilders.put(uri).content(json).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(400));
	}
}
