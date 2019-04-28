package com.bteam.backendservice.v1.repository

import com.bteam.backendservice.v1.model.Recipents
import org.springframework.data.repository.CrudRepository

interface RecipentsRepository : CrudRepository<Recipents, Int> {
}