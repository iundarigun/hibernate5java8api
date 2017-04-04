package br.com.devcave.hibernate5java8api.repository;

import java.util.Optional;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.devcave.hibernate5java8api.entity.Trabalhador;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by s2it_ocanalias on 4/4/17.
 */
@Slf4j
public class TrabalhadorRepositoryCustomImpl implements TrabalhadorRepositoryCustom {

    @Autowired
    private EntityManager entityManager;

    @Override
    public Optional<Trabalhador> getOptionalTrabalhadorById(final Long id) {
        Session session = entityManager.unwrap(Session.class);
        Optional<Trabalhador> trabalhador = session.byId(Trabalhador.class).loadOptional(id);
        if (trabalhador.isPresent()) {
            log.info("Trabalhador encontrado={}", trabalhador.get().toString());
        } else {
            log.info("Trabalhador não existe");
        }
        return trabalhador;
    }
}
