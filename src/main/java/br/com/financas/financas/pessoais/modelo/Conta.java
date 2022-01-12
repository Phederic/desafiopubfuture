package br.com.financas.financas.pessoais.modelo;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Conta {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer contaId;
	private BigDecimal saldo;
	private String instituicaoFinanceira;
	@Enumerated(EnumType.STRING)
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
	
	public Conta(BigDecimal saldo, String instituicaoFinanceira, TipoConta tipoConta) {
		this.saldo = saldo;
		this.instituicaoFinanceira = instituicaoFinanceira;
		this.tipoConta = tipoConta;
	}
	
	public Conta() {
	}
	
}
