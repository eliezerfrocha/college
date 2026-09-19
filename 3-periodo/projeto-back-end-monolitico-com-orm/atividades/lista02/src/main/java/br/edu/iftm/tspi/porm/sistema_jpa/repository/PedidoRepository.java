package br.edu.iftm.tspi.porm.sistema_jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.edu.iftm.tspi.porm.sistema_jpa.domain.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
    
    List<Pedido> findByClienteId(String clienteId);
    
    @Query("SELECT p FROM Pedido p JOIN FETCH p.detalhesPedido WHERE p.id = :pedidoId")
    Pedido findByIdWithDetalhes(@Param("pedidoId") Integer pedidoId);
    
    @Query("SELECT p FROM Pedido p JOIN FETCH p.cliente WHERE p.id = :pedidoId")
    Pedido findByIdWithCliente(@Param("pedidoId") Integer pedidoId);
} 