package br.edu.iftm.tspi.porm.sistema_jpa.repository;

import org.springframework.stereotype.Repository;
import br.edu.iftm.tspi.porm.sistema_jpa.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

    List<Produto> findByCategoriaId(Integer categoriaId);

    List<Produto> findByNomeContainingIgnoreCase(String nome);

}
