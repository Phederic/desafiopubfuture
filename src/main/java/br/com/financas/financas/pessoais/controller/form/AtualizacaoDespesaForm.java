package br.com.financas.financas.pessoais.controller.form;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.financas.financas.pessoais.modelo.Conta;
import br.com.financas.financas.pessoais.modelo.Despesa;
import br.com.financas.financas.pessoais.modelo.TipoDespesa;
import br.com.financas.financas.pessoais.repository.DespesasRepository;

public class AtualizacaoDespesaForm {

	private Integer id;
	private BigDecimal valor;
	private LocalDate dataPagamento;
	private LocalDate dataPagamentoEsperado;
	private Conta conta;
	private TipoDespesa tipoDespesa;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public LocalDate getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(LocalDate dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public LocalDate getDataPagamentoEsperado() {
		return dataPagamentoEsperado;
	}

	public void setDataPagamentoEsperado(LocalDate dataPagamentoEsperado) {
		this.dataPagamentoEsperado = dataPagamentoEsperado;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public TipoDespesa getTipoDespesa() {
		return tipoDespesa;
	}

	public void setTipoDespesa(TipoDespesa tipoDespesa) {
		this.tipoDespesa = tipoDespesa;
	}

	public Despesa converter() {
		return new Despesa();
	}

	public Despesa atualizar(Integer id, DespesasRepository despesasRepository) {
		Despesa despesa = despesasRepository.getById(id);
		despesa.setValor(this.valor);
		despesa.setDataPagamentoEsperado(this.dataPagamentoEsperado);
		despesa.setTipoDespesa(this.tipoDespesa);
		return despesa;
	}
}
