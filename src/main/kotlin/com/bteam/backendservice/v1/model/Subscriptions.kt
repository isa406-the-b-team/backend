package com.bteam.backendservice.v1.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "subscriptions")
data class Subscriptions (
    @Id
    @Column(name = "subscriptionid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,
    @Column(name = "paperid")
    val paper: Int,
    @Column(name = "recipientid")
    val recipient: Int,
    @Column(name = "datecreated")
    val datecreated: LocalDateTime,
    @Column(name = "dateended")
    val dateended: LocalDateTime? = null,
    @Column(name = "deliverydays")
    val days: Byte
)

/*
    adding routes
    {
        routeId: String
        recipients: [
            {
                street1: String,
                city: String,
                state: String,
                zip: String,
                newspapers: [
                    {
                        newspaperCode: String
                        days: 01111111
                    }
                ]
            } ...
        ]

    }
 */


/*
    retrieving routes
    Get /*/:routeId
    {

        recipients: [
            {
                street1: String,
                city: String,
                state: String,
                zip: String,
                newspapers: [
                    {
                        newspaperCode: String
                        days: 01111111
                    }
                ]
            } ...
        ]

    }
 */
*/