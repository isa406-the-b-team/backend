package com.bteam.backendservice.v1.model.request

data class Newspaper(
    val newspaperCode: String,
    val days: Int
)

data class Route (
    val street1: String,
    val city: String,
    val state: String,
    val zip: String,
    val newspapers: List<Newspaper> = listOf()
)

data class RouteRequest (
    val routeId: String,
    val recipients: List<Route>
)
