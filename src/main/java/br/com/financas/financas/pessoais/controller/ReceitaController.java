package br.com.financas.financas.pessoais.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import br.com.financas.financas.pessoais.controller.form.AtualizacaoReceitaForm;
import br.com.financas.financas.pessoais.controller.form.ReceitaForm;
import br.com.financas.financas.pessoais.dto.ReceitaDto;
import br.com.financas.financas.pessoais.modelo.Receita;
import br.com.financas.financas.pessoais.repository.ReceitaRepository;

@RestController
@RequestMapping("/receita")
public class ReceitaController {
	
	@Autowired
	private ReceitaRepository receitaRepository;
	
	
	
	@GetMapping
	public List<ReceitaDto> lista() {
				List<Receita> receitas = receitaRepository.findAll();
		return ReceitaDto.converter(receitas);
		
	}	
	
	@PostMapping
	@Transactional
	public ResponseEntity<ReceitaDto> cadastrar(@RequestBody @Valid ReceitaForm form, UriComponentsBuilder uriBuilder) {
		Receita receita = form.converter();
		receitaRepository.save(receita);
		
		URI uri = uriBuilder.path("/receita/{id}").buildAndExpand(receita.getId()).toUri();
		return ResponseEntity.created(uri).body(new ReceitaDto(receita));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ReceitaDto> detalhar(@PathVariable Integer id) {
		Optional<Receita> receita = receitaRepository.findById(id);
		if(receita.isPresent()) {
		return ResponseEntity.ok(new ReceitaDto(receita.get()));
		}
		return ResponseEntity.notFound().build();
	}
	
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ReceitaDto> atualizar(@PathVariable Integer id, @RequestBody @Valid AtualizacaoReceitaForm form ){
		Optional<Receita> receitaAtt = receitaRepository.findById(id);
		if(receitaAtt.isPresent()) {
			Receita receita = form.atualizar(id, receitaRepository);
			return ResponseEntity.ok(new ReceitaDto(receita));
		}
		return ResponseEntity.notFound().build();
	}
		
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Integer id){
		Optional<Receita> receitaDel = receitaRepository.findById(id);
		if(receitaDel.isPresent()) {
			receitaRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	
	
	
	
	
	
	
	
}
