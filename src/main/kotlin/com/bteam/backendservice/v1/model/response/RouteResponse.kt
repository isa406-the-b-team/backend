package com.bteam.backendservice.v1.model.response

import com.bteam.backendservice.v1.model.request.Route

data class RouteResponse (
    val routes: List<Route> = listOf()
)