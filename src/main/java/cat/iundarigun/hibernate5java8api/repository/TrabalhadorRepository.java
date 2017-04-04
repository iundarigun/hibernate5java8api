package cat.iundarigun.hibernate5java8api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cat.iundarigun.hibernate5java8api.entity.Trabalhador;

public interface TrabalhadorRepository extends JpaRepository<Trabalhador, Long>, TrabalhadorRepositoryCustom {

}
