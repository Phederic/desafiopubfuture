package br.com.financas.financas.pessoais.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;

import br.com.financas.financas.pessoais.modelo.Conta;
import br.com.financas.financas.pessoais.modelo.Receita;
import br.com.financas.financas.pessoais.modelo.TipoReceita;

public class ReceitaDto {
	private Integer id;
	private BigDecimal valor;
	private String descricao;
	private TipoReceita tipoReceita;
	private LocalDate dataRecebimento;
	private LocalDate dataRecebimentoEsperado;
	private Conta conta;

	public Integer getId() {
		return id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public TipoReceita getTipoReceita() {
		return tipoReceita;
	}

	public LocalDate getDataRecebimento() {
		return dataRecebimento;
	}

	public LocalDate getDataRecebimentoEsperado() {
		return dataRecebimentoEsperado;
	}

	public Conta getConta() {
		return conta;
	}

	public ReceitaDto(Receita receita) {
		this.id = receita.getId();
		this.valor = receita.getValor();
		this.descricao = receita.getDescricao();
		this.tipoReceita = receita.getTipoReceita();
		this.dataRecebimento = receita.getDataRecebimento();
		this.dataRecebimentoEsperado = receita.getDataRecebimentoEsperado();
		this.conta = receita.getConta();
	}

	public static Page<ReceitaDto> converter(Page<Receita> receitas) {
		return receitas.map(ReceitaDto::new);
	}

}
