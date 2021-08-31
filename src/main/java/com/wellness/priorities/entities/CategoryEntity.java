package com.wellness.priorities.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "categories_m")
@NoArgsConstructor
@Getter
@Setter
public class CategoryEntity implements Serializable {

    @Id
    @Column(name = "category_id")
    private int categoryId;

    @Column
    private String name;

    @Column
    private String description;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "default_order")
    private int defaultOrder;

    @OneToMany(mappedBy = "category")
    private List<UserSatisfactionEntity> userSatisfactionEntities;
}
