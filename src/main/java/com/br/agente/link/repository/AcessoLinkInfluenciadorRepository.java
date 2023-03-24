/**
 *
 */
package com.br.agente.link.repository;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.br.agente.link.repository.model.AcessoLinkInfluenciador;
import com.br.agente.link.repository.model.LinkInfluenciador;

/**
 * @author Jorge Demetrio
 * @since 15 de abr de 2020 22:34:38
 * @version 1.0
 */
@Repository
public interface AcessoLinkInfluenciadorRepository extends JpaRepository<AcessoLinkInfluenciador, String> {

    /**
     * Retorna a consulta.
     *
     * @param linkInfluenciador Link origem.
     * @param ip                Ip de quem consulta.
     * @param ipReal            Ip real da máquina.
     * @param hostname          nome da maquina.
     * @param session           sessiona.
     * @param inicio            Data de ontem.
     * @return Um Optional.
     * @since 16 de abr de 2020 01:11:22
     */
    @Query("SELECT a FROM AcessoLinkInfluenciador AS a WHERE a.ip = :ip " + " AND a.linkInfluenciador = :linkInfluenciador" + " AND a.ipReal = :ipReal"
            + " AND a.session = :session" + " AND a.hostname = :hostname " + " AND  a.acesso >= :inicio ")
    Optional<AcessoLinkInfluenciador> buscarAcessoLinkUltimoDia(LinkInfluenciador linkInfluenciador, String ip, String ipReal, String hostname, String session,
            LocalDateTime inicio);

}
