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
import br.com.financas.financas.pessoais.repository.ReceitaRepository;

public class AtualizacaoReceitaForm {

	private BigDecimal valor;
	private TipoReceita tipoReceita;
	@NotNull @NotEmpty @Length(min = 10)
	private String descricao;
	private List<Conta> conta = new ArrayList<>();
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
	
	
	public List<Conta> getConta() {
		return conta;
	}
	public void setConta(List<Conta> conta) {
		this.conta = conta;
	}
	public Receita atualizar(Integer id, ReceitaRepository receitaRepository) {
		Receita receita = receitaRepository.getById(id);
		receita.setValor(this.valor);
		receita.setDescricao(this.descricao);
		receita.setTipoReceita(this.tipoReceita);
		return receita;
	}
	
	
}
