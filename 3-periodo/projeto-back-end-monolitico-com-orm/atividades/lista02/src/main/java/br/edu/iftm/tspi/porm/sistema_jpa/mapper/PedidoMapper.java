package br.edu.iftm.tspi.porm.sistema_jpa.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import br.edu.iftm.tspi.porm.sistema_jpa.domain.Pedido;
import br.edu.iftm.tspi.porm.sistema_jpa.dto.PedidoDto;

@Mapper(componentModel = "spring", uses = {DetalhePedidoMapper.class})
public interface PedidoMapper {
    
    PedidoMapper INSTANCE = Mappers.getMapper(PedidoMapper.class);
    
    @Mapping(target = "clienteId", source = "cliente.id")
    PedidoDto toDto(Pedido pedido);
    
    @Mapping(target = "cliente.id", source = "clienteId")
    @Mapping(target = "cliente.nome", ignore = true)
    @Mapping(target = "cliente.cargo", ignore = true)
    @Mapping(target = "cliente.endereco", ignore = true)
    @Mapping(target = "cliente.cidade", ignore = true)
    @Mapping(target = "cliente.cep", ignore = true)
    @Mapping(target = "cliente.pais", ignore = true)
    @Mapping(target = "cliente.telefone", ignore = true)
    @Mapping(target = "cliente.fax", ignore = true)
    @Mapping(target = "cliente.pedidos", ignore = true)
    Pedido toEntity(PedidoDto pedidoDto);
    
    List<PedidoDto> toDtoList(List<Pedido> pedidos);
    
    List<Pedido> toEntityList(List<PedidoDto> pedidoDtos);
} 