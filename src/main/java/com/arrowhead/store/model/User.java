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
@Table("users")
public class User implements Persistable<UUID> {

    @Id
    @Column("id")
    private UUID id;

    @Column("name")
    private String name;

    @Column("last_name")
    private String lastName;

    @Column("email")
    private String email;

    @Transient
    private Boolean isNewUser = false;

    @Override
    public boolean isNew() {
        return isNewUser;
    }

}
