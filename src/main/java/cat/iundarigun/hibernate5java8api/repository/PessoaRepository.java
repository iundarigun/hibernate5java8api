package cat.iundarigun.hibernate5java8api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cat.iundarigun.hibernate5java8api.entity.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
