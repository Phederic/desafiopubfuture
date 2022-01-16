package br.com.financas.financas.pessoais.repository;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.financas.financas.pessoais.modelo.Receita;
import br.com.financas.financas.pessoais.modelo.TipoReceita;

@Repository
public interface ReceitaRepository extends JpaRepository<Receita, Integer> {

	Page<Receita> findByTipoReceita(TipoReceita tipoReceita, Pageable paginacao);

	Page<Receita> findByDataRecebimentoBetween(LocalDate primeiraData, LocalDate segundaData, Pageable paginacao);

}
