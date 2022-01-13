package br.com.financas.financas.pessoais.controller.form;

import java.math.BigDecimal;

import br.com.financas.financas.pessoais.modelo.Conta;
import br.com.financas.financas.pessoais.modelo.TipoConta;
import br.com.financas.financas.pessoais.repository.ContaRepository;

public class AtualizacaoContaForm {

	private Integer contaId;
	private BigDecimal saldo;
	private String instituicaoFinanceira;
	private TipoConta tipoConta;

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

	public Conta converter() {
		return new Conta(saldo, instituicaoFinanceira, tipoConta);
	}

	public Conta atualizar(Integer id, ContaRepository contaRepository) {
		Conta conta = contaRepository.getById(id);
		conta.setInstituicaoFinanceira(this.instituicaoFinanceira);
		conta.setSaldo(this.saldo);
		conta.setTipoConta(this.tipoConta);
		return conta;
	}
}
