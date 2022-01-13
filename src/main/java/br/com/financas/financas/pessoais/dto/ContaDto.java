package br.com.financas.financas.pessoais.dto;

import java.math.BigDecimal;

import org.springframework.data.domain.Page;

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
	
	public static Page<ContaDto> converter(Page<Conta> conta) {
		return conta.map(ContaDto::new); 
	}
	

		
	}

