package br.edu.iftm.tspi.porm.sistema_jpa.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDto {
    private Integer codigo;

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @Positive(message = "O preço deve ser maior que zero")
    private String preco;

    @Min(value = 0, message = "Não existe estoque negativo")
    private Integer estoque;

    private String caminhoImagem;

    private Integer categoriaId;

    public void setId(Integer id) {
        this.codigo = id;
    }
}
