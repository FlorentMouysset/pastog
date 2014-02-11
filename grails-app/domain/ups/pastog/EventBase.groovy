package ups.pastog

import ups.pastog.user.User;

class EventBase {

    String description
	Date dateOfStart
	Date dateOfEnd
	SubDomain subdomain

	static BelongTo = [author : User ]
	static hasMany=[ participants: User]
    static constraints = {
        dateOfStart(nullable: false, max:(dateOfEnd))
        dateOfEnd(nullable: false, min:(dateOfStart))
        description(nullable: false)
    }
}
