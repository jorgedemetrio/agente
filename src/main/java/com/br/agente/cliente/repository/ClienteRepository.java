/**
 *
 */
package com.br.agente.cliente.repository;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.br.agente.cliente.repository.model.Cliente;

/**
 * @author Jorge Demetrio
 * @since 16 de abr de 2020 22:07:42
 * @version 1.0
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, UUID> {

    Page<Cliente> findByNome(@Param("nome") final String nome, Pageable pag);

}
