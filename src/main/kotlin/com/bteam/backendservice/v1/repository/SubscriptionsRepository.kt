package com.bteam.backendservice.v1.repository

import com.bteam.backendservice.v1.model.Subscriptions
import org.springframework.data.repository.CrudRepository

interface SubscriptionsRepository : CrudRepository<Subscriptions, Int>