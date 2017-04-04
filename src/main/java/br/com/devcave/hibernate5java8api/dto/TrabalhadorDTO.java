package br.com.devcave.hibernate5java8api.dto;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Optional;

import lombok.Data;

/**
 * Created by s2it_ocanalias on 4/4/17.
 */
@Data
public class TrabalhadorDTO {
    private Long id;
    private String nome;
    private LocalDate dataNascimento;
    private Duration duracao;

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(final Optional<LocalDate> dataNascimento) {
        this.dataNascimento = dataNascimento.orElse(null);
    }
}
