/**
 *
 */
package com.br.agente.cliente.repository;

import java.awt.print.Pageable;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.br.agente.cliente.repository.model.Cliente;
import com.br.agente.cliente.repository.model.Produto;

/**
 * @author Jorge Demetrio
 * @since 16 de abr de 2020 23:04:12
 * @version 1.0
 */
public interface ProdutoRespository extends JpaRepository<Produto, UUID> {

    Page<Cliente> findByNome(@Param("nome") final String nome, Pageable pag);

}
