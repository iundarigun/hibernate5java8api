package br.com.devcave.hibernate5java8api.entity;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString
public class Trabalhador {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_trabalhador")
    private Long id;

    @Column(name = "nom_trabalhador", nullable = false)
    private String nome;

    @Column(name = "dat_nascimento")
    private LocalDate dataNascimento;

    @Column(name = "num_duracao_jornada")
    private Duration duracaoJornada;

    @Column(name = "dat_criacao")
    private LocalDateTime dataCriacao;

    @Column(name = "dat_alteracao")
    private LocalDateTime dataAlteracao;

    @PrePersist
    public void prePersist() {
        dataCriacao = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        dataAlteracao = LocalDateTime.now();
    }

    public Optional<LocalDate> getDataNascimento() {
        return Optional.ofNullable(dataNascimento);
    }

}
