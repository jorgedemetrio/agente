/**
 *
 */
package com.br.agente.link.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.agente.link.repository.model.LinkInfluenciador;

/**
 * @author Jorge Demetrio
 * @since 15 de abr de 2020 22:34:38
 * @version 1.0
 */
@Repository
public interface LinkInfluenciadorRepository extends JpaRepository<LinkInfluenciador, String> {

}
