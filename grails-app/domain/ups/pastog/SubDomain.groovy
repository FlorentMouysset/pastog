package ups.pastog

import ups.pastog.user.User;

class SubDomain {

    String label
    static  belongsTo = [domaine:Domain]

    static hasMany=[ virtualEvent: VirtualEvent,  physicalEvent: PhysicalEvent ]

    static constraints = {
        label(blank: false, unique : true)
        domaine( blank : false)
    }
}
