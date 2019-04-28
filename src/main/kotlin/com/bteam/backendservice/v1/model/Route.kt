package com.bteam.backendservice.v1.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "routes")
data class Route (
    @Id
    @Column(name = "routeid")
    val routeid: String,
    @Column(name = "inuse")
    val inUse: Boolean
)