/**
 *
 */
package com.br.agente.link.service;

import static java.util.Objects.isNull;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.br.agente.link.repository.AcessoLinkInfluenciadorRepository;
import com.br.agente.link.repository.LinkInfluenciadorRepository;
import com.br.agente.link.repository.model.AcessoLinkInfluenciador;
import com.br.agente.link.repository.model.LinkInfluenciador;

import lombok.RequiredArgsConstructor;

/**
 * @author Jorge Demetrio
 * @since 15 de abr de 2020 22:35:41
 * @version 1.0
 */
@RequiredArgsConstructor
@Service
public class AcessoLinkInfluencidadorService {

    private final LinkInfluenciadorRepository linkInfluenciadorRepository;
    private final AcessoLinkInfluenciadorRepository acessoLinkInfluenciadorRepository;
    private final Integer UM = 1;

    public String pegarLinkPorInlfluenciador(final String id, final String ip, final String realIp, final String hostname, final String sessionId) {

        final Optional<LinkInfluenciador> linkInfluenciadorOptional = linkInfluenciadorRepository.findById(id);
        AcessoLinkInfluenciador itemAcesso;

        if (linkInfluenciadorOptional.isPresent()) {
            final LinkInfluenciador linkInfluenciador = linkInfluenciadorOptional.get();

            final LocalDateTime inicio = LocalDateTime.now().minusDays(1l);

            final Optional<AcessoLinkInfluenciador> item = acessoLinkInfluenciadorRepository.buscarAcessoLinkUltimoDia(linkInfluenciador, ip,
                    isNull(realIp) || realIp.isEmpty() ? ip : realIp, isNull(hostname) || hostname.isEmpty() ? ip : hostname, sessionId, inicio);

            if (item.isPresent()) {
                itemAcesso = item.get();
                itemAcesso.setTentativas(isNull(itemAcesso.getTentativas()) ? UM : itemAcesso.getTentativas() + UM);
                acessoLinkInfluenciadorRepository.save(itemAcesso);
            } else {
                itemAcesso = new AcessoLinkInfluenciador(null, linkInfluenciador, ip, realIp, sessionId, hostname, LocalDateTime.now(), UM);
                acessoLinkInfluenciadorRepository.save(itemAcesso);

                linkInfluenciador.setTotalAcessos(isNull(linkInfluenciador.getTotalAcessos()) ? UM : linkInfluenciador.getTotalAcessos() + UM);
                linkInfluenciador.setUltimoAcesso(LocalDateTime.now());
                linkInfluenciadorRepository.save(linkInfluenciador);
            }

            return linkInfluenciador.getLink().getUrl();
        }
        return null;
    }

}

