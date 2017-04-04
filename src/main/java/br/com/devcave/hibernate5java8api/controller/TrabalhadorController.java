package br.com.devcave.hibernate5java8api.controller;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.devcave.hibernate5java8api.entity.Trabalhador;
import br.com.devcave.hibernate5java8api.repository.TrabalhadorRepository;

@RestController
public class TrabalhadorController {

    @Autowired
    private TrabalhadorRepository trabalhadorRepository;

    @RequestMapping(value = "/trabalhador/criar", method = RequestMethod.POST)
    public Long crearTrabahador(@RequestParam String nome, @RequestParam String dataNascimento,
            @RequestParam Integer horas) {
        Trabalhador trabalhador = new Trabalhador();
        trabalhador.setNome(nome);
        trabalhador.setDataNascimento(LocalDate.parse(dataNascimento, DateTimeFormatter.ISO_DATE));
        trabalhador.setDuracaoJornada(Duration.ofHours(horas));
        return trabalhadorRepository.save(trabalhador).getId();
    }

    @RequestMapping(value = "/trabalhador/{id}", method = RequestMethod.GET)
    public String recuperarTrabahador(@PathVariable Long id) {
        Optional<Trabalhador> trabalhador = trabalhadorRepository.getOptionalTrabalhadorById(id);
        return trabalhador.orElse(new Trabalhador()).toString();
    }

    @RequestMapping(value = "/trabalhadores/nome/{nome}", method = RequestMethod.GET)
    @Transactional
    public List<String> recuperarTrabahador(@PathVariable String nome) {
        Stream<Trabalhador> trabalhadores = trabalhadorRepository.findByNome(nome);
        return trabalhadores.map(t -> t.toString()).collect(Collectors.toList());
    }

}
