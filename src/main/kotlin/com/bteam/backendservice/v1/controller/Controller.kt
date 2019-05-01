package com.bteam.backendservice.v1.controller

import com.bteam.backendservice.v1.model.request.CreateNewspaper
import com.bteam.backendservice.v1.model.request.Newspaper
import com.bteam.backendservice.v1.model.request.Route
import com.bteam.backendservice.v1.model.request.RouteRequest
import com.bteam.backendservice.v1.model.response.RecipientRespones
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

    @GetMapping("/newspaper/{routeId}")
    fun getNewpaperCount(@RequestParam("routeId") routeId: String): HttpEntity<Response<Map<String, List<Map<String,Any>>>>> {
        return HttpEntity(
            Response(
                mapOf("newspapers" to listOf(
                    mapOf("code" to "test1", "number" to 7),
                    mapOf("code" to "test7", "number" to 5)
                ))
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

    @DeleteMapping("/newspaper/{newspaperCode}")
    fun deleteNewspapers(@RequestParam("newspaperCode") newspaperCode: String): HttpEntity<Response<String>> {
        databaseService.deleteNewspapers(newspaperCode)
        return HttpEntity(
            Response("Deleted")
        )
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
                    recipients = listOf(1,2,3,4,5)
                )
            )
        )
    }

    @GetMapping("/route/recipient/{recipientId}")
    fun getRecipient(@RequestParam("recipientId") recipientId: String): HttpEntity<Response<RecipientRespones>> {
        return HttpEntity(
            Response(
                RecipientRespones(
                    recipient = Route(
                        street1 = "3770 Southpointe Pkwy",
                        city = "Oxford",
                        state = "OH",
                        zip = "45056",
                        newspapers = listOf(
                            Newspaper(
                                newspaperCode = "test7",
                                days = 10
                            )
                        )
                    )
                )
            )
        )
    }

}