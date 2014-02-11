package ups.pastog

import ups.pastog.user.User;

class EventBase {

    String description
	Date dateOfStart
	Date dateOfEnd
    static BelongTo = [user:User]
	static hasMany=[ participants: User]
    SubDomain subdomain
    static constraints = {
        dateOfStart(nullable: false, max:(dateOfEnd))
        dateOfEnd(nullable: false, min:(dateOfStart))
        description(nullable: false)
    }
}
