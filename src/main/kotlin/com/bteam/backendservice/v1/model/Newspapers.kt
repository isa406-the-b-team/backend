package com.bteam.backendservice.v1.model

import javax.persistence.*

@Entity
@Table(name = "newspapers")
data class Newspapers(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "paperid")
    val paperId: Int = 0,
    @Column(name = "papername") // PaperCodes
    val name: String
)
