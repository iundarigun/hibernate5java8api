package br.com.devcave.hibernate5java8api.repository;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import br.com.devcave.hibernate5java8api.dto.TrabalhadorDTO;
import br.com.devcave.hibernate5java8api.entity.Trabalhador;

/**
 * Created by s2it_ocanalias on 4/4/17.
 */
@Mapper(componentModel = "spring")
public interface TrabalhadorMapper {

    TrabalhadorMapper INSTANCE = Mappers.getMapper(TrabalhadorMapper.class);

    // @Mappings({
    // @Mapping(target = "dataNascimento", ignore = true),
    // @Mapping(source = "duracaoJornada", target = "duracao"),
    // @Mapping(target = "duracaoJornada", ignore = true),
    // @Mapping(target = "dataCriacao", ignore = true),
    // @Mapping(target = "dataAlteracao", ignore = true)
    // @Mapping(source = "id", target = "id") })
    // @Mapping(source = "id", target = "id")
    @Mapping(source = "duracaoJornada", target = "duracao")
    TrabalhadorDTO trabalhadorToTrabalhadorDTO(Trabalhador trabalhador);

    @InheritInverseConfiguration
    Trabalhador trabalhadorDTOToTrabalhador(TrabalhadorDTO trabalhadorDTO);
}
