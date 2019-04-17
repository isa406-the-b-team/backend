package com.bteam.backendservice.v1.model

import java.sql.Date
import javax.persistence.*

@Entity
@Table("cancellations")
data class Cancellations(
    @Id
    @Column("cancelid")
    val id: Int,
    @OneToMany
    @Column("subscriptionid")
    val subscriptions: Subscriptions,
    @OneToMany
    @Column("recipientid")
    val recipents: Recipents,
    @Column("cancelstart")
    val start: Date,
    @Column("cancelstop")
    val stop: Date
)