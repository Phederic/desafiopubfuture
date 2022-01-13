package br.com.financas.financas.pessoais.controller.form;

import java.math.BigDecimal;

import br.com.financas.financas.pessoais.modelo.Conta;
import br.com.financas.financas.pessoais.modelo.TipoConta;

public class ContaForm {
	
	private Integer contaId;
	private BigDecimal saldo;
	private String instituicaoFinanceira;
	private TipoConta tipoConta;
	
	public Integer getContaId() {
		return contaId;
	}
	public void setContaId(Integer contaId) {
		this.contaId = contaId;
	}
	public BigDecimal getSaldo() {
		return saldo;
	}
	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}
	public String getInstituicaoFinanceira() {
		return instituicaoFinanceira;
	}
	public void setInstituicaoFinanceira(String instituicaoFinanceira) {
		this.instituicaoFinanceira = instituicaoFinanceira;
	}
	public TipoConta getTipoConta() {
		return tipoConta;
	}
	public void setTipoConta(TipoConta tipoConta) {
		this.tipoConta = tipoConta;
	}
	
	public Conta converter() {
		return new Conta(saldo, instituicaoFinanceira, tipoConta);
	}
}
