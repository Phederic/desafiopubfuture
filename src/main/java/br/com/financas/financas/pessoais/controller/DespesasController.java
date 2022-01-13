package br.com.financas.financas.pessoais.controller;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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

import br.com.financas.financas.pessoais.controller.form.AtualizacaoDespesaForm;
import br.com.financas.financas.pessoais.controller.form.DespesaForm;
import br.com.financas.financas.pessoais.dto.DespesaDto;
import br.com.financas.financas.pessoais.modelo.Despesa;
import br.com.financas.financas.pessoais.repository.DespesasRepository;

@RestController
@RequestMapping("/despesas")
public class DespesasController {

	@Autowired
	private DespesasRepository despesasRepository;
	
	@GetMapping
	@Cacheable(value = "listaDeDespesas")
	public Page<DespesaDto> lista(@PageableDefault(sort = "id", direction = Direction.ASC, page=0, size=10) Pageable paginacao) {
		Page<Despesa> despesa = despesasRepository.findAll(paginacao);
		return DespesaDto.converter(despesa);
	}
	
	@PostMapping
	@Transactional
	@CacheEvict(value = "listaDeDespesa" , allEntries = true)
	public ResponseEntity<DespesaDto> cadastrar(@RequestBody @Valid DespesaForm form, UriComponentsBuilder uriBuilder) {
		Despesa despesa = form.converter();
		despesasRepository.save(despesa);
		
		URI uri = uriBuilder.path("/despesas/{id}").buildAndExpand(despesa.getId()).toUri();
		return ResponseEntity.created(uri).body(new DespesaDto(despesa));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DespesaDto> detalhar(@PathVariable Integer id) {
		Optional<Despesa> despesa = despesasRepository.findById(id);
		if(despesa.isPresent()) {
		return ResponseEntity.ok(new DespesaDto(despesa.get()));
		}
		return ResponseEntity.notFound().build();
	}
	

	@PutMapping("/{id}")
	@Transactional
	@CacheEvict(value = "listaDeDespesa" , allEntries = true)
	public ResponseEntity<DespesaDto> atualizar(@PathVariable Integer id, @RequestBody @Valid AtualizacaoDespesaForm form ){
		Optional<Despesa> despesaAtt = despesasRepository.findById(id);
		if(despesaAtt.isPresent()) {
			Despesa despesa = form.atualizar(id, despesasRepository);
			return ResponseEntity.ok(new DespesaDto(despesa));
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	@CacheEvict(value = "listaDeDespesa" , allEntries = true)
	public ResponseEntity<?> remover(@PathVariable Integer id){
		Optional<Despesa> despesaDel = despesasRepository.findById(id);
		if(despesaDel.isPresent()) {
			despesasRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	
	
	
	
	
}

