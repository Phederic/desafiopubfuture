package br.com.financas.financas.pessoais.controller.form;

import java.math.BigDecimal;

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
	private Conta tipoConta;
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
	public Conta getTipoConta() {
		return tipoConta;
	}
	public void setTipoConta(Conta tipoConta) {
		this.tipoConta = tipoConta;
	}
	public Receita atualizar(Integer id, ReceitaRepository receitaRepository) {
		Receita receita = receitaRepository.getById(id);
		receita.setValor(this.valor);
		receita.setDescricao(this.descricao);
		receita.setTipoReceita(this.tipoReceita);
		return receita;
	}
	
	
}
