package br.com.financas.financas.pessoais.dto;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import br.com.financas.financas.pessoais.modelo.Conta;
import br.com.financas.financas.pessoais.modelo.TipoConta;
import br.com.financas.financas.pessoais.repository.ContaRepository;

public class ContaDto {

	private Integer contaId;
	private BigDecimal saldo;
	private String instituicaoFinanceira;
	private TipoConta tipoConta;

	@Autowired
	ContaRepository contaRepository;

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

	public void setContaId(Integer contaId) {
		this.contaId = contaId;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public void setInstituicaoFinanceira(String instituicaoFinanceira) {
		this.instituicaoFinanceira = instituicaoFinanceira;
	}

	public void setTipoConta(TipoConta tipoConta) {
		this.tipoConta = tipoConta;
	}

	public static Page<ContaDto> converter(Page<Conta> conta) {
		return conta.map(ContaDto::new);
	}
	
	public ContaDto() {
	}
}
