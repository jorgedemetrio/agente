/**
 *
 */
package com.br.agente.link.repository.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Jorge Demetrio
 * @since 7 de abr de 2020 02:34:47
 * @version 1.0
 */
@Entity
@Data
@Table(name = "tb_link_acesso_infl")
@AllArgsConstructor
@NoArgsConstructor
public class AcessoLinkInfluenciador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_acesso_link_infl", insertable = false, updatable = false, nullable = true)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_link_indluencidor", insertable = true, updatable = false, nullable = false)
    private LinkInfluenciador linkInfluenciador;

    @NotEmpty
    @Column(name = "ip", insertable = true, updatable = false, nullable = false, length = 25)
    private String ip;

    @NotEmpty
    @Column(name = "ip_real", insertable = true, updatable = false, nullable = false, length = 25)
    private String ipReal;

    @NotEmpty
    @Column(name = "session_id", insertable = true, updatable = false, nullable = false, length = 30)
    private String session;

    @NotEmpty
    @Column(name = "hotname", insertable = true, updatable = false, nullable = false, length = 200)
    private String hostname;

    @NotNull
    @Column(name = "dt_primeiro_acesso", insertable = true, updatable = false, nullable = false)
    private LocalDateTime acesso;


    @NotNull
    @Column(name = "tentativas", insertable = true, updatable = true, nullable = true)
    private Integer tentativas;

}
