/**
 *
 */
package com.br.agente.cliente.controller;

import static java.util.Objects.isNull;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.br.agente.cliente.repository.model.Cliente;
import com.br.agente.cliente.service.ClienteService;

import lombok.RequiredArgsConstructor;

/**
 * @author Jorge Demetrio
 * @since 17 de abr de 2020 00:13:22
 * @version 1.0
 */
@Controller
@RequiredArgsConstructor
@RequestMapping(path = "/cliente")
public class ClienteController {

    private final ClienteService service;

    @ResponseStatus(code = HttpStatus.FOUND)
    @GetMapping(path = "/{id}")
    public ModelAndView get(@NotEmpty @PathVariable("id") final String id) {
        final ModelAndView modelAndView = new ModelAndView();

        final Cliente cliente = service.pegar(id);

        if (isNull(cliente)) {
            modelAndView.setStatus(HttpStatus.NOT_FOUND);
            modelAndView.setViewName("/");
        } else {
            modelAndView.addObject("item", cliente);
        }

        return modelAndView;
    }

    @ResponseStatus(code = HttpStatus.GONE)
    @PostMapping(path = "/")
    public ModelAndView save(@Valid @RequestBody final Cliente cliente) {

        service.gravar(cliente);

        return new ModelAndView();
    }

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping(path = "/")
    public ModelAndView search() {

        return new ModelAndView();
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PutMapping(path = "/{id}")
    public ModelAndView update() {

        return new ModelAndView();
    }
}
