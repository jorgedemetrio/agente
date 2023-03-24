/**
 *
 */
package com.br.agente.redesocial.repostiory.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Jorge Demetrio
 * @since 6 de abr de 2020 07:55:18
 * @version 1.0
 */
@Entity
@Data
@Table(name = "tb_redesocial")
@AllArgsConstructor
@NoArgsConstructor
public class RedeSocial implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -8911490811933891551L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_redesocial", insertable = false, updatable = false, nullable = true)
    private Long id;

    @NotEmpty
    @Column(name = "nome", insertable = true, updatable = true, nullable = false, length = 200)
    private String nome;

    @NotEmpty
    @Column(name = "url", insertable = true, updatable = true, nullable = false, length = 200)
    private String url;
}
