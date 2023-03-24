/**
 *
 */
package com.br.agente.cliente.service;

import org.springframework.stereotype.Service;

import com.br.agente.cliente.repository.ProdutoRespository;

import lombok.RequiredArgsConstructor;

/**
 * @author Jorge Demetrio
 * @since 16 de abr de 2020 23:39:09
 * @version 1.0
 */
@RequiredArgsConstructor
@Service
public class ProdutoService {
    private final ProdutoRespository produtoRespository;


}
