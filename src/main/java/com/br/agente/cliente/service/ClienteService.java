/**
 *
 */
package com.br.agente.cliente.service;

import static java.util.Objects.isNull;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.br.agente.cliente.repository.ClienteRepository;
import com.br.agente.cliente.repository.model.Cliente;

import lombok.RequiredArgsConstructor;

/**
 * @author Jorge Demetrio
 * @since 16 de abr de 2020 23:05:15
 * @version 1.0
 */
@RequiredArgsConstructor
@Service
public class ClienteService {

    private ClienteRepository clienteRepository;

    public Page<Cliente> buscar(final String nome, final Integer pagina, final Integer itensPorPagina ) {
        final String nomeFormatado = isNull(nome) || nome.trim().isEmpty() ? null : "%"+nome.trim().toLowerCase() + "%";
        return clienteRepository.findByNome(nomeFormatado, PageRequest.of(pagina, itensPorPagina, Direction.ASC, "nome"));
    }

    public void delete(final String id) {
        clienteRepository.deleteById(UUID.fromString(id));
    }

    public Cliente gravar(@Valid final Cliente cliente) {
        cliente.setId(UUID.randomUUID());
        return clienteRepository.save(cliente);
    }

    public Cliente pegar(final String id) {
        return clienteRepository.findById(UUID.fromString(id)).get();
    }

}
