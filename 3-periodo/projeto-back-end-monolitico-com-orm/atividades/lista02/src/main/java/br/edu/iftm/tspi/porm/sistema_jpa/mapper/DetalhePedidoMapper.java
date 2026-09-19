package br.edu.iftm.tspi.porm.sistema_jpa.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import br.edu.iftm.tspi.porm.sistema_jpa.domain.DetalhePedido;
import br.edu.iftm.tspi.porm.sistema_jpa.dto.DetalhePedidoDto;

@Mapper(componentModel = "spring")
public interface DetalhePedidoMapper {
    
    DetalhePedidoMapper INSTANCE = Mappers.getMapper(DetalhePedidoMapper.class);
    
    @Mapping(target = "produtoId", source = "produto.codigo")
    DetalhePedidoDto toDto(DetalhePedido detalhePedido);
    
    @Mapping(target = "produto.codigo", source = "produtoId")
    @Mapping(target = "produto.nome", ignore = true)
    @Mapping(target = "produto.categoria", ignore = true)
    @Mapping(target = "produto.preco", ignore = true)
    @Mapping(target = "produto.estoque", ignore = true)
    @Mapping(target = "produto.caminhoImagem", ignore = true)
    @Mapping(target = "pedido", ignore = true)
    @Mapping(target = "id.pedidoId", ignore = true)
    @Mapping(target = "id.produtoId", source = "produtoId")
    DetalhePedido toEntity(DetalhePedidoDto detalhePedidoDto);
    
    List<DetalhePedidoDto> toDtoList(List<DetalhePedido> detalhesPedido);
    
    List<DetalhePedido> toEntityList(List<DetalhePedidoDto> detalhePedidoDtos);
} 