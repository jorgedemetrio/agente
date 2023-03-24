/**
 *
 */
package com.br.agente.link.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.br.agente.link.service.AcessoLinkInfluencidadorService;

import lombok.RequiredArgsConstructor;

/**
 * @author Jorge Demetrio
 * @since 15 de abr de 2020 22:04:56
 * @version 1.0
 */
@Controller
@RequiredArgsConstructor
@RequestMapping(path = "/r")
public class RedirectController {

    private final AcessoLinkInfluencidadorService service;

    @ResponseStatus(code = HttpStatus.FOUND)
    @GetMapping(path = "/{id}")
    public ModelAndView redirect(@PathVariable(name = "id", required = true) final String id, final HttpServletRequest request) {



        final String url = service.pegarLinkPorInlfluenciador(id, request.getRemoteAddr(), request.getHeader("X-FORWARDED-FOR"), request.getRemoteHost(), request.getSession().getId());

        ModelAndView response;
        response = new ModelAndView("redirect:" + url);

        return response;

    }

}
