package ups.pastog

import ups.pastog.user.User;

class EventBase {

    String description
	Date dateOfStart
	Date dateOfEnd
    SubDomain subdomain
    static BelongTo = [user:User]
	static hasMany=[ participants: User]
    static constraints = {


        description(nullable: false)
        dateOfEnd(validator: { val, obj ->
            val?.after(obj.dateOfStart)
        })
        dateOfStart(validator: { val, obj ->
            val?.before(obj.dateOfEnd)
        })
    }
}
