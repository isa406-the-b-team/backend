package com.bteam.backendservice.v1.model

import java.sql.Date
import javax.persistence.*

@Entity
@Table("subscriptions")
data class Subscriptions (
    @Id
    @Column("subscriptionid")
    val id: Int,
    @ManyToOne
    @Column("paperId")
    val paper: Newspapers,
    @ManyToOne
    @Column("recipientid")
    val recipient: Recipents,
    @Column("datecreated")
    val datecreated: Date,
    @Column("dateended")
    val dateended: Date?
)

/*
    adding routes
    {
        routeId: String
        routes: [
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

        routes: [
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
    retrieving newspapers
    {
        newspapers: [<newspapercodes>]

    }

 */