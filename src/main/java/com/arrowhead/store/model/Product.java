package com.arrowhead.store.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Data
@NoArgsConstructor
@Table("products")
public class Product implements Persistable<UUID> {

    @Id
    @Column("id")
    private UUID id;

    @Column("name")
    private String name;

    @Column("price")
    private Integer price;

    @Transient
    private Boolean isNewProduct = false;

    @Override
    public boolean isNew() {
        return isNewProduct;
    }

}
