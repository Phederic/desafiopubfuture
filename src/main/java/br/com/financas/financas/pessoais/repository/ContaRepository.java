package br.com.financas.financas.pessoais.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.financas.financas.pessoais.modelo.Conta;

public interface ContaRepository extends JpaRepository<Conta, Integer> {

}
