package com.bteam.backendservice.v1.repository

import com.bteam.backendservice.v1.model.Route
import org.springframework.data.repository.CrudRepository

interface RouteRepository : CrudRepository<Route, String>