package br.com.financas.financas.pessoais.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import br.com.financas.financas.pessoais.modelo.Conta;
import br.com.financas.financas.pessoais.modelo.TipoConta;

public class ContaDto {
	
	private Integer contaId;
	private BigDecimal saldo;
	private String instituicaoFinanceira;
	private TipoConta tipoConta;
	
	public ContaDto(Conta conta) {
		this.contaId = conta.getContaId();
		this.saldo = conta.getSaldo();
		this.instituicaoFinanceira = conta.getInstituicaoFinanceira();
		this.tipoConta = conta.getTipoConta();
	}
	
	public Integer getContaId() {
		return contaId;
	}
	public BigDecimal getSaldo() {
		return saldo;
	}
	public String getInstituicaoFinanceira() {
		return instituicaoFinanceira;
	}
	public TipoConta getTipoConta() {
		return tipoConta;
	}
	
	public static List<ContaDto> converter(List<Conta> conta) {
		return conta.stream().map(ContaDto::new).collect(Collectors.toList());
	}
	
	
}
