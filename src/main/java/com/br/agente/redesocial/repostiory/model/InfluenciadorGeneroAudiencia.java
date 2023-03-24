/**
 *
 */
package com.br.agente.redesocial.repostiory.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Jorge Demetrio
 * @since 6 de abr de 2020 07:56:52
 * @version 1.0
 */
@Entity
@Data
@Table(name = "tb_influenciador_genero_audiencia")
@AllArgsConstructor
@NoArgsConstructor
public class InfluenciadorGeneroAudiencia implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -2478723214972136589L;

    @EmbeddedId
    private InfluenciadorGeneroAudienciaPk id;

    @NotNull
    @Column(name = "genero", insertable = true, updatable = true, nullable = false, length = 1)
    private GeneroEnum genero;

    @NotNull
    @Column(name = "participacao", insertable = true, updatable = true, nullable = false)
    private Float participacao;

}
