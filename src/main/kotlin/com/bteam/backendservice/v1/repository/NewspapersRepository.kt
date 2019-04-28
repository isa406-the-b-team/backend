package com.bteam.backendservice.v1.repository

import com.bteam.backendservice.v1.model.Newspapers
import org.springframework.data.repository.CrudRepository

interface NewspapersRepository : CrudRepository<Newspapers, Int> {
}