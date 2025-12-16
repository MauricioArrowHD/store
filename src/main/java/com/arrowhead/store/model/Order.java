package com.arrowhead.store.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@Table("orders")
public class Order implements Persistable<UUID> {

    @Id
    @Column("id")
    private UUID id;

    @Column("user_id")
    private UUID userId;

    @Column("product_id")
    private UUID productId;

    @Column("quantity")
    private Integer quantity;

    @Column("order_date")
    private LocalDateTime orderDate;

    @Transient
    private Boolean isNewOrder = false;

    @Override
    public boolean isNew() {
        return isNewOrder;
    }

}
