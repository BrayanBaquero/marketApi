package com.devcode.marketplace.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "clientes")
@Getter
@Setter
public class Cliente {
    @Id
    @Column(name = "id_cliente")
    private Integer idCliente;

    private String nombre;

    private String apellido;

    private Integer celular;

    private String direccion;

    @Column(name = "correo_electronico")
    private String correolEctronico;
}
