package com.example.userregistration.common;




import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@ToString
@MappedSuperclass
//@EntityListeners(AuditTrailListener.class)
public abstract class BaseEntity
        implements Serializable {
    private Long id;
    @Id
    @GeneratedValue
    @Column(name = "id")

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}