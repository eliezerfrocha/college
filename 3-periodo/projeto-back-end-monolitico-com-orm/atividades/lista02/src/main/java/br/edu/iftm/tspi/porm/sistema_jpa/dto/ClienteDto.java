package br.edu.iftm.tspi.porm.sistema_jpa.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDto {
    
    @Size(max = 5, message = "ClienteID deve ter no máximo 5 caracteres")
    private String id;
    
    @NotBlank(message = "Nome não pode ser vazio")
    @Size(max = 30, message = "Nome deve ter no máximo 30 caracteres")
    private String nome;
    
    @Size(max = 30, message = "Cargo deve ter no máximo 30 caracteres")
    private String cargo;
    
    @NotBlank(message = "Endereço não pode ser vazio")
    @Size(max = 40, message = "Endereço deve ter no máximo 40 caracteres")
    private String endereco;
    
    @NotBlank(message = "Cidade não pode ser vazia")
    @Size(max = 30, message = "Cidade deve ter no máximo 30 caracteres")
    private String cidade;
    
    @Size(max = 10, message = "CEP deve ter no máximo 10 caracteres")
    private String cep;
    
    @NotBlank(message = "País não pode ser vazio")
    @Size(max = 24, message = "País deve ter no máximo 24 caracteres")
    private String pais;
    
    @Size(max = 24, message = "Telefone deve ter no máximo 24 caracteres")
    private String telefone;
    
    @Size(max = 24, message = "Fax deve ter no máximo 24 caracteres")
    private String fax;
} 