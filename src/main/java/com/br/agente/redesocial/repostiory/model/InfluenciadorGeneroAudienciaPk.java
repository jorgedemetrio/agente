/**
 *
 */
package com.br.agente.redesocial.repostiory.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.br.agente.pessoas.repository.model.Influenciador;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Jorge Demetrio
 * @since 6 de abr de 2020 07:58:36
 * @version 1.0
 */
@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InfluenciadorGeneroAudienciaPk implements Serializable {


    /**
     *
     */
    private static final long serialVersionUID = -1729449592898731240L;

    @ManyToOne
    @JoinColumn(name = "id_influenciador", insertable = true, updatable = false, nullable = false)
    private Influenciador influenciador;

    @ManyToOne
    @JoinColumn(name = "id_redesocial", insertable = true, updatable = false, nullable = false)
    private RedeSocial redesocial;
}
