package com.bteam.backendservice.v1.model

import java.sql.Date
import javax.persistence.*

@Entity
@Table(name = "cancellations")
data class Cancellations(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cancelid")
    val id: Int,
    @Column(name = "subscriptionid")
    val subscriptions: Int,
    @Column(name = "recipientid")
    val recipents: Int,
    @Column(name = "cancelstart")
    val start: Date,
    @Column(name = "cancelstop")
    val stop: Date
)