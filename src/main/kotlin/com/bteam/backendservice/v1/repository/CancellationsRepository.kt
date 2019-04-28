package com.bteam.backendservice.v1.repository

import com.bteam.backendservice.v1.model.Cancellations
import org.springframework.data.jpa.repository.JpaRepository
import javax.transaction.Transactional


@Transactional
interface CancellationsRepository : JpaRepository<Cancellations, Int>