package br.edu.iftm.tspi.porm.sistema_jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.edu.iftm.tspi.porm.sistema_jpa.domain.Produto;
import br.edu.iftm.tspi.porm.sistema_jpa.dto.ProdutoDto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

    List<Produto> findByNomeContainingIgnoreCase(String nome);
    
    @Query(nativeQuery = true, value = """
        SELECT 
            p.produtoid as id,
            p.produtonome as nome,
            p.preco as preco,
            p.unidadesemestoque as estoque,
            p.imagem,
            p.categoriaID
        FROM produtos p
        WHERE p.preco = (
            SELECT MAX(p2.preco) 
            FROM produtos p2
            WHERE p2.categoriaid = p.categoriaid
        )
    """)
    List<ProdutoDto> findProdutosComMaiorPrecoPorCategoria();
}
