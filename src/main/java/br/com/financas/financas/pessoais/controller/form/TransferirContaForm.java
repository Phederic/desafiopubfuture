package br.com.financas.financas.pessoais.controller.form;

import java.math.BigDecimal;

import br.com.financas.financas.pessoais.modelo.Conta;
import br.com.financas.financas.pessoais.modelo.TipoConta;
import br.com.financas.financas.pessoais.repository.ContaRepository;

public class TransferirContaForm {

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

	public BigDecimal contaDestino(Integer contaId, BigDecimal saldo, ContaRepository contaRepository) {
		Conta conta = contaRepository.getById(contaId);
		conta.setSaldo(saldo.add(getSaldo()));
		contaRepository.save(conta);
		return conta.getSaldo();

	}

	public BigDecimal contaRemetente(Integer contaId, BigDecimal saldo, ContaRepository contaRepository) {
		Conta conta = contaRepository.getById(contaId);
		conta.setSaldo(saldo.subtract(getSaldo()));
		contaRepository.save(conta);
		return conta.getSaldo();
	}

	public void transferir(Integer contaRemetenteId, Integer contaDestinoId, BigDecimal valorTransferido,
			ContaRepository contaRepository) {
		Conta contaDestino = contaRepository.getById(contaDestinoId);
		Conta contaRemetente = contaRepository.getById(contaRemetenteId);
		this.contaRemetente(contaRemetenteId, valorTransferido, contaRepository);
		this.contaDestino(contaDestinoId, valorTransferido, contaRepository);

	}

}
