package com.bteam.backendservice.v1.model

import org.hibernate.annotations.Table
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
@Table("recipients")
data class Recipents(
    @Id
    @Column("recipientid")
    val id: Int,
    @Column("fname")
    val firstName: String?,
    @Column("lname")
    val lastName: String?,
    @ManyToOne
    @Column("routeid")
    val route: Route,
    @Column("street")
    val street: String,
    @Column("city")
    val city: String,
    @Column("state")
    val state: String,
    @Column("zip")
    val zip: Int
)