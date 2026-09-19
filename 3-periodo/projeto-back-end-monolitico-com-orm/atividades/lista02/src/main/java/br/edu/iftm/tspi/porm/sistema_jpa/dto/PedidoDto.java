package br.edu.iftm.tspi.porm.sistema_jpa.dto;

import java.util.Date;
import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDto {
    
    private Integer id;
    
    private Date dataPedido;
    
    @NotBlank(message = "ClienteID não pode ser vazio")
    private String clienteId;
    
    @NotEmpty(message = "Pedido deve ter pelo menos um item")
    @Valid
    private List<DetalhePedidoDto> detalhesPedido;
} 