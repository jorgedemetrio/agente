/**
 *
 */
package com.br.agente.link.repository.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Jorge Demetrio
 * @since 6 de abr de 2020 23:48:11
 * @version 1.0
 */
@Entity
@Data
@Table(name = "tb_link_produto")
@AllArgsConstructor
@NoArgsConstructor
public class Link implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 243364704438981610L;

    @Size(min = 5, max = 255)
    @Id
    @Column(name = "url", insertable = true, updatable = false, nullable = false, length = 255)
    private String url;

    @Column(name = "descricao", insertable = true, updatable = true, nullable = false, length = 2000)
    private String descricao;
}
