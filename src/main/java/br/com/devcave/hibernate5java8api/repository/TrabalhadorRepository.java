package br.com.devcave.hibernate5java8api.repository;

import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.devcave.hibernate5java8api.entity.Trabalhador;

public interface TrabalhadorRepository extends JpaRepository<Trabalhador, Long>, TrabalhadorRepositoryCustom {

    Stream<Trabalhador> findByNome (String nome);

}
