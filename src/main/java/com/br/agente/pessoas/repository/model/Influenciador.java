/**
 *
 */
package com.br.agente.pessoas.repository.model;

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
 * @since 6 de abr de 2020 07:59:21
 * @version 1.0
 */
@Entity
@Data
@Table(name = "tb_influenciador")
@AllArgsConstructor
@NoArgsConstructor
public class Influenciador implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 7421930704803590399L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_influenciador", insertable = false, updatable = false, nullable = true)
    private Long id;

    @NotEmpty
    @Column(name = "nome", insertable = true, updatable = true, nullable = false, length = 200)
    private String nome;

    @NotEmpty
    @Column(name = "apelido", insertable = true, updatable = true, nullable = false, length = 200)
    private String apelido;
}
