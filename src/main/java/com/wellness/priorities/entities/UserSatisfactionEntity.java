package com.wellness.priorities.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "user_satisfaction_t")
@NoArgsConstructor
@Getter
@Setter
public class UserSatisfactionEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "category_id")
    private int categoryId;

    @Column(name = "rating_id")
    private int ratingId;

    @Column(name = "order_id")
    private int orderId;

    @Column(name = "is_deleted")
    private boolean isDeleted;

    @Column(name = "created_time")
    private Timestamp createdTime;

    @Column(name = "last_updated_time")
    private Timestamp lastUpdatedBy;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", referencedColumnName = "category_id", insertable = false, updatable = false)
    private CategoryEntity category;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rating_id", referencedColumnName = "ratingId", insertable = false, updatable = false)
    private SatisfactionRatingEntity rating;

}
