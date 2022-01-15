package br.com.financas.financas.pessoais.controller;

import java.math.BigDecimal;
import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.financas.financas.pessoais.controller.form.AtualizacaoContaForm;
import br.com.financas.financas.pessoais.controller.form.ContaForm;
import br.com.financas.financas.pessoais.dto.ContaDto;
import br.com.financas.financas.pessoais.modelo.Conta;
import br.com.financas.financas.pessoais.modelo.TipoConta;
import br.com.financas.financas.pessoais.repository.ContaRepository;

@RestController
@RequestMapping("/conta")
public class ContaController {

	@Autowired
	private ContaRepository contaRepository;

	@GetMapping
	public Page<ContaDto> lista(
			@PageableDefault(sort = "ContaId", direction = Direction.ASC, page = 0, size = 10) Pageable paginacao,
			TipoConta tipoConta) {
		if (tipoConta == null) {
			Page<Conta> contas = contaRepository.findAll(paginacao);
			return ContaDto.converter(contas);
		} else {
			Page<Conta> contas = contaRepository.findByTipoConta(tipoConta, paginacao);
			return ContaDto.converter(contas);
		}
	}

	@PostMapping
	@Transactional
	public ResponseEntity<ContaDto> cadastrar(@RequestBody @Valid ContaForm form, UriComponentsBuilder uriBuilder) {
		Conta conta = form.converter();
		contaRepository.save(conta);

		URI uri = uriBuilder.path("/conta/{id}").buildAndExpand(conta.getContaId()).toUri();
		return ResponseEntity.created(uri).body(new ContaDto(conta));
	}

	@GetMapping("/{id}")
	public ResponseEntity<ContaDto> detalhar(@PathVariable Integer contaId) {
		Optional<Conta> conta = contaRepository.findById(contaId);
		if (conta.isPresent()) {
			return ResponseEntity.ok(new ContaDto(conta.get()));
		}
		return ResponseEntity.notFound().build();
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ContaDto> atualizar(@PathVariable Integer id, @RequestBody @Valid AtualizacaoContaForm form) {
		Optional<Conta> contaAtt = contaRepository.findById(id);
		if (contaAtt.isPresent()) {
			Conta conta = form.atualizar(id, contaRepository);
			return ResponseEntity.ok(new ContaDto(conta));
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Integer id) {
		Optional<Conta> contaDel = contaRepository.findById(id);
		if (contaDel.isPresent()) {
			contaRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

	@GetMapping("/soma")
	public BigDecimal SomaTotalDeSaldo() {
		Conta conta = new Conta();
		contaRepository.SaldoTotal().ifPresent(conta::setSaldo);
		return conta.getSaldo();
	}

}

