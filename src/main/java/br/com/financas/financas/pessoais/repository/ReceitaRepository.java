package br.com.financas.financas.pessoais.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.financas.financas.pessoais.modelo.Receita;
import br.com.financas.financas.pessoais.modelo.TipoReceita;

public interface ReceitaRepository extends JpaRepository<Receita, Integer>{

	Page<Receita> findByTipoReceita(TipoReceita tipoReceita, Pageable paginacao);

}
	