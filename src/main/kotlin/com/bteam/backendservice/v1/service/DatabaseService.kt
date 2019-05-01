package com.bteam.backendservice.v1.service

import com.bteam.backendservice.v1.model.Newspapers
import com.bteam.backendservice.v1.model.Recipents
import com.bteam.backendservice.v1.model.Route
import com.bteam.backendservice.v1.model.Subscriptions
import com.bteam.backendservice.v1.model.request.Newspaper
import com.bteam.backendservice.v1.model.request.RouteRequest
import com.bteam.backendservice.v1.model.response.RouteResponse
import com.bteam.backendservice.v1.repository.NewspapersRepository
import com.bteam.backendservice.v1.repository.RecipentsRepository
import com.bteam.backendservice.v1.repository.RouteRepository
import com.bteam.backendservice.v1.repository.SubscriptionsRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class DatabaseService(
    private val newspapersRepository: NewspapersRepository,
    private val routeRepository: RouteRepository,
    private val recipentsRepository: RecipentsRepository,
    private val subscriptionsRepository: SubscriptionsRepository
) {

    fun addNewspaper(newspaper: String): Boolean {
        return try {
            newspapersRepository.save(
                Newspapers(
                    name = newspaper
                )
            )
            true
        } catch (exception: Exception) {
            exception.printStackTrace()
            false
        }
    }

    fun getNewspapers(): List<String> {
        return newspapersRepository.findAll().map {
            it.name
        }
    }

    fun deleteNewspapers(paperCode: String) {
        newspapersRepository.findAll().filter {
            it.name == paperCode
        }.forEach {
            newspapersRepository.delete(it)
        }
    }

    fun addRoute(routeRequest: RouteRequest): Boolean {
       return try {
           val routeId = routeRepository.save(
               Route(
                   routeid = routeRequest.routeId,
                   inUse = true
               )
           )
           routeRequest.recipients.forEachIndexed { index, route ->
               val saved = recipentsRepository.save(Recipents(
                   route = routeId.routeid,
                   street = route.street1,
                   city = route.city,
                   state = route.state,
                   zip = route.zip.toInt(),
                   order = index)
               )
               route.newspapers.forEach {
                   val newspaperId = newspapersRepository.findAll().first { savedPaper ->
                       savedPaper.name == it.newspaperCode
                   }.paperId
                   subscriptionsRepository.save(
                       Subscriptions(
                           paper = newspaperId,
                           recipient = saved.id,
                           datecreated = LocalDateTime.now(),
                           days = it.days.toByte()
                       )
                   )
               }

           }

           true
       } catch (exception: Exception) {
           exception.printStackTrace()
           false
       }
    }

    fun getRouteIds(): List<String> {
        return routeRepository.findAll().map {
            it.routeid
        }
    }

    fun getRoute(routeName: String): List<com.bteam.backendservice.v1.model.request.Route> {
        return recipentsRepository.findAll().filter { it.route == routeName }.sortedBy { it.order }.map {recp ->
            val subscriptions = subscriptionsRepository.findAll().filter { recp.id == it.recipient }

            val newspapers = subscriptions.map {
                val newspaper = newspapersRepository.findById(it.paper)
                Newspaper(
                    newspaperCode = newspaper.get().name,
                    days = it.days.toInt()
                )
            }

            com.bteam.backendservice.v1.model.request.Route(
                street1 = recp.street,
                city = recp.city,
                state = recp.state,
                zip = recp.zip.toString(),
                newspapers = newspapers
            )
        }
    }

}