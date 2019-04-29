package com.bteam.backendservice.v1.controller

import com.bteam.backendservice.v1.model.request.CreateNewspaper
import com.bteam.backendservice.v1.model.request.RouteRequest
import com.bteam.backendservice.v1.model.response.Response
import com.bteam.backendservice.v1.model.response.RouteResponse
import com.bteam.backendservice.v1.service.DatabaseService
import org.springframework.http.HttpEntity
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class Controller(
    val databaseService: DatabaseService
) {

    @GetMapping("/newspaper")
    fun getNewspapers(): HttpEntity<Response<List<String>>> {
        return HttpEntity(
            Response(
                data = databaseService.getNewspapers()
            )
        )
    }

    @PostMapping("/newspaper")
    fun createNewspaper(
        @RequestBody
        createNewspaper: CreateNewspaper
    ): ResponseEntity<Response<String>> {
        val ret = databaseService.addNewspaper(createNewspaper.newspaper)

        return if(ret) {
            ResponseEntity(
                Response(
                    data = "Created"
                ),
                HttpStatus.CREATED
            )
        } else {
            ResponseEntity(
                Response(
                    data = "Error Occured"
                ),
                HttpStatus.INTERNAL_SERVER_ERROR
            )
        }

    }

    @PostMapping("/route")
    fun createRoute(
        @RequestBody
        request: RouteRequest
    ): ResponseEntity<Response<String>> {

        val ret = databaseService.addRoute(request)
        return if(ret) {
            ResponseEntity(
                Response(
                    data = "Created"
                ),
                HttpStatus.CREATED
            )
        } else {
            ResponseEntity(
                Response(
                    data = "Error Occured"
                ),
                HttpStatus.INTERNAL_SERVER_ERROR
            )
        }
    }

    @GetMapping("/route")
    fun getRoutes(): HttpEntity<Response<List<String>>>  {
        return HttpEntity(
            Response(
                data = databaseService.getRouteIds()
            )
        )

    }

    @GetMapping("/route/{routeId}")
    fun getRoute(@RequestParam("routeId") routeId: String): HttpEntity<Response<RouteResponse>> {
        return HttpEntity(
            Response(
                RouteResponse(
                    routes = databaseService.getRoute(routeId)
                )
            )
        )
    }

}