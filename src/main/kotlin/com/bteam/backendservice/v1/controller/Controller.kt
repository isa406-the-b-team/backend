package com.bteam.backendservice.v1.controller

import com.bteam.backendservice.v1.model.request.RouteRequest
import com.bteam.backendservice.v1.model.response.Response
import com.bteam.backendservice.v1.model.response.RouteResponse
import org.springframework.http.HttpEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class Controller {

    @GetMapping("/newspapers")
    fun getNewspapers(): HttpEntity<Response<Any>> {
        return HttpEntity(
            Response(
                data = Any()
            )
        )
    }


    @PostMapping("/route")
    fun createRoute(request: RouteRequest): HttpEntity<Any> {
        return HttpEntity(object{})
    }

    @GetMapping("/route/\${routeId}")
    fun getRoute(@RequestParam("routeId") routeId: String): HttpEntity<Response<RouteResponse>> {
        return HttpEntity(
            Response(
                RouteResponse()
            )
        )
    }

}