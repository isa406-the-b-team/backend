package com.bteam.backendservice.v1.model

import org.hibernate.annotations.Table
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
@Table("routes")
data class Route (
    @Id
    @Column("routeid")
    val routeid: String,
    @Column("inuse")
    val inUse: Boolean
)