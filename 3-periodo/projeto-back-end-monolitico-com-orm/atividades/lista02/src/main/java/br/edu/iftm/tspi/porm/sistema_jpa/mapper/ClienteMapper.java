package br.edu.iftm.tspi.porm.sistema_jpa.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.edu.iftm.tspi.porm.sistema_jpa.domain.Cliente;
import br.edu.iftm.tspi.porm.sistema_jpa.dto.ClienteDto;

@Mapper(componentModel = "spring")
public interface ClienteMapper {
    
    ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);
    
    ClienteDto toDto(Cliente cliente);
    
    Cliente toEntity(ClienteDto clienteDto);
    
    List<ClienteDto> toDtoList(List<Cliente> clientes);
    
    List<Cliente> toEntityList(List<ClienteDto> clienteDtos);
} 