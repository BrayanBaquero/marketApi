package com.devcode.marketplace.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "compras_producto")
@Getter
@Setter
public class ComprasProducto {
    @EmbeddedId
    private ComprasProductoPk id;

    private Integer cantidad;

    private Double total;

    private Boolean estado;
}
