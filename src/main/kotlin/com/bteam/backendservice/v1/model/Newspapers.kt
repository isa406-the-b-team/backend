package com.bteam.backendservice.v1.model

import org.hibernate.annotations.Table
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
@Table("newspapers")
data class Newspapers(
    @Id
    @Column("paperid")
    val paperId: Int,
    @Column("papername") // PaperCodes
    val name: String,
    @Column("distscale")
    val scale: String?,
    @Column("distscheme")
    val scheme: String?
)
