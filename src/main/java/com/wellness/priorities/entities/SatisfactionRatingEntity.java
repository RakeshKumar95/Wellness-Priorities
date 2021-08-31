package com.wellness.priorities.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "satisfaction_rating_m")
@NoArgsConstructor
@Getter
@Setter
public class SatisfactionRatingEntity implements Serializable {

    @Id
    @Column(name = "ratingId")
    private int ratingId;

    @Column
    private String name;

    @OneToMany(mappedBy = "rating")
    private List<UserSatisfactionEntity> userSatisfactionEntities;
}
