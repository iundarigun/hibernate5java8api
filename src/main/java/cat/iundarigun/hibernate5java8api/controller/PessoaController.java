package cat.iundarigun.hibernate5java8api.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cat.iundarigun.hibernate5java8api.entity.Pessoa;
import cat.iundarigun.hibernate5java8api.repository.PessoaRepository;

@RestController
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @RequestMapping(value = "/pessoa/criar", method = RequestMethod.POST)
    public Long crearPessoa(@RequestParam String nome, @RequestParam String dataNascimento) {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(nome);
        pessoa.setDataNascimento(LocalDate.parse(dataNascimento, DateTimeFormatter.ISO_DATE));
        return pessoaRepository.save(pessoa).getId();
    }
}
