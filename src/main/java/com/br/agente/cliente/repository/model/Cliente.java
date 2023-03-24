/**
 *
 */
package com.br.agente.cliente.repository.model;

import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Jorge Demetrio
 * @since 16 de abr de 2020 21:36:17
 * @version 1.0
 */
@Entity
@Data
@Table(name = "tb_cliente")
@AllArgsConstructor
@NoArgsConstructor
public class Cliente implements Serializable {


    /**
     *
     */
    private static final long serialVersionUID = -2344892924611937782L;

    @Id
    @Column(name = "id_cliente", insertable = true, updatable = false, nullable = false)
    private UUID id;

    @NotEmpty
    @Size(max = 255)
    @Column(name = "nome", insertable = true, updatable = true, nullable = false, length = 255)
    private String nome;

    @Size(max = 2000)
    @Column(name = "descricao", insertable = true, updatable = true, nullable = true, length = 2000)
    private String descricao;

    @OneToMany(mappedBy = "cliente")
    private Set<Produto> produtos;
}
