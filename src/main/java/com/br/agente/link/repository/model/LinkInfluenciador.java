/**
 *
 */
package com.br.agente.link.repository.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.br.agente.pessoas.repository.model.Influenciador;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Jorge Demetrio
 * @since 7 de abr de 2020 02:11:07
 * @version 1.0
 */
@Entity
@Data
@Table(name = "tb_link_influenciador")
@AllArgsConstructor
@NoArgsConstructor
public class LinkInfluenciador implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 3722161729841002744L;

    @Id
    @Column(name = "id_link_influencidador", insertable = true, updatable = false, nullable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "id_influenciador", insertable = true, updatable = false, nullable = false)
    private Influenciador influenciador;

    @ManyToOne
    @JoinColumn(name = "id_site", insertable = true, updatable = false, nullable = false)
    private Link link;

    @Column(name = "dt_criador", insertable = true, updatable = false, nullable = false)
    private LocalDateTime criado;

    @Column(name = "dt_primeiro_acesso", insertable = true, updatable = false, nullable = true)
    private LocalDateTime primeiroAcesso;

    @Column(name = "dt_para_link", insertable = true, updatable = true, nullable = true)
    private LocalDateTime parar;

    @Column(name = "dt_ultimo_acesso", insertable = true, updatable = true, nullable = true)
    private LocalDateTime ultimoAcesso;

    @Column(name = "total_acessos", insertable = true, updatable = true, nullable = true)
    private Long totalAcessos;

    @OneToMany(mappedBy = "linkInfluenciador")
    private AcessoLinkInfluenciador acessos;

}
