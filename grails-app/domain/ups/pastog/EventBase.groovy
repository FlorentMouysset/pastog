package ups.pastog

import ups.pastog.user.User;

class EventBase {

    String title
    String description
	Date dateOfStart
	Date dateOfEnd
    SubDomain subdomain
    //static BelongTo = [user:User]
    User user
	static hasMany=[ participants: User]
    static constraints = {

        description(blank: false)
        dateOfEnd(blank: false,validator: { val, obj ->
            val?.after(obj.dateOfStart)
        })
        dateOfStart(blank: false,validator: { val, obj ->
            val?.before(obj.dateOfEnd)
        })
    }
}
