package br.edu.iftm.tspi.porm.sistema_jpa.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DetalhePedidoDto {
    
    @NotNull(message = "ProdutoID é obrigatório")
    private Integer produtoId;
    
    @NotNull(message = "Preço de venda é obrigatório")
    @DecimalMin(value = "0.01", message = "Preço de venda deve ser maior que zero")
    private Double precoVenda;
    
    @NotNull(message = "Quantidade é obrigatória")
    @DecimalMin(value = "1", message = "Quantidade deve ser maior que zero")
    private Short quantidade;
    
    @DecimalMin(value = "0.0", message = "Desconto não pode ser negativo")
    private Double desconto;
} 