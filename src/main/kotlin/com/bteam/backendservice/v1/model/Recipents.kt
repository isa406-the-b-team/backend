package com.bteam.backendservice.v1.model

import javax.persistence.*

@Entity
@Table(name = "recipients")
data class Recipents(
    @Id
    @Column(name = "recipientid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,
    @Column(name = "fname")
    val firstName: String? = null,
    @Column(name = "lname")
    val lastName: String? = null,
    @Column(name = "routeid")
    val route: String,
    @Column(name = "street")
    val street: String,
    @Column(name = "city")
    val city: String,
    @Column(name = "state")
    val state: String,
    @Column(name = "zip")
    val zip: Int,
    @Column(name = "routeorder")
    val order: Int
)