package br.edu.iftm.tspi.porm.sistema_jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.edu.iftm.tspi.porm.sistema_jpa.domain.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String> {
    
    List<Cliente> findByNomeContainingIgnoreCase(String nome);
    
    List<Cliente> findByCidadeContainingIgnoreCase(String cidade);
    
    @Query("SELECT c FROM Cliente c JOIN FETCH c.pedidos WHERE c.id = :clienteId")
    Cliente findByIdWithPedidos(@Param("clienteId") String clienteId);
} 