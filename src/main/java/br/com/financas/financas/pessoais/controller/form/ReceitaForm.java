package br.com.financas.financas.pessoais.controller.form;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.financas.financas.pessoais.modelo.Conta;
import br.com.financas.financas.pessoais.modelo.Receita;
import br.com.financas.financas.pessoais.modelo.TipoReceita;

public class ReceitaForm {
	
	
	private BigDecimal valor;
	private TipoReceita tipoReceita;
	@NotNull @NotEmpty @Length(min = 10)
	private String descricao;
	private Conta conta;

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public TipoReceita getTipoReceita() {
		return tipoReceita;
	}

	public void setTipoReceita(TipoReceita tipoReceita) {
		this.tipoReceita = tipoReceita;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public Receita converter() {
		return new Receita(valor, descricao, tipoReceita);
	}

}
