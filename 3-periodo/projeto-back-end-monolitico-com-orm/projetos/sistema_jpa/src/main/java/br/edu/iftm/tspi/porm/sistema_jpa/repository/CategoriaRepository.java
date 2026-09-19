package br.edu.iftm.tspi.porm.sistema_jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.edu.iftm.tspi.porm.sistema_jpa.domain.Categoria;

@Repository
public interface CategoriaRepository extends 
                            JpaRepository<Categoria, Integer>{

    /* 2.1. Mesmo efeito de findByNomeContainingIgnoreCase, porém nativo */
    @Query(value = """
            SELECT * 
              FROM categorias 
             WHERE LOWER(categoria) LIKE LOWER(CONCAT('%', :nome, '%'))
            """, nativeQuery = true)
    List<Categoria> buscarPorNomeNativo(@Param("nome") String nome);


    /* 2.2. Lista categorias já com a qtde de produtos em cada uma */
    @Query(value = """
            SELECT c.categoriaid     AS categoriaId,
                   c.categoria       AS categoria,
                   COUNT(p.produtoid) AS totalProdutos
              FROM categorias c
         LEFT JOIN produtos   p ON p.categoriaid = c.categoriaid
          GROUP BY c.categoriaid, c.categoria
            """, nativeQuery = true)
    public List<Categoria> findByNomeContainingIgnoreCase(String nome);

}
