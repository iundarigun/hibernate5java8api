package cat.iundarigun.hibernate5java8api.repository;

import java.util.Optional;

import cat.iundarigun.hibernate5java8api.entity.Trabalhador;

public interface TrabalhadorRepositoryCustom {
    Optional<Trabalhador> getOptionalTrabalhadorById(Long id);
}
