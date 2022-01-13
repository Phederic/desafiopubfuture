package br.com.financas.financas.pessoais.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;

import br.com.financas.financas.pessoais.modelo.Conta;
import br.com.financas.financas.pessoais.modelo.Despesa;
import br.com.financas.financas.pessoais.modelo.TipoDespesa;

public class DespesaDto {

	private Integer id;
	private BigDecimal valor;
	private LocalDate dataPagamento;
	private LocalDate dataPagamentoEsperado;
	private TipoDespesa tipoDespesa;
	private Conta conta;

	public Integer getId() {
		return id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public LocalDate getDataPagamento() {
		return dataPagamento;
	}

	public LocalDate getDataPagamentoEsperado() {
		return dataPagamentoEsperado;
	}

	public TipoDespesa getTipoDespesa() {
		return tipoDespesa;
	}

	public Conta getConta() {
		return conta;
	}

	public DespesaDto(Despesa despesa) {
		this.id = despesa.getId();
		this.valor = despesa.getValor();
		this.dataPagamento = despesa.getDataPagamento();
		this.dataPagamentoEsperado = despesa.getDataPagamentoEsperado();
		this.tipoDespesa = despesa.getTipoDespesa();
		this.conta = despesa.getConta();
	}

	public static Page<DespesaDto> converter(Page<Despesa> despesas) {
		return despesas.map(DespesaDto::new);
	}
}
