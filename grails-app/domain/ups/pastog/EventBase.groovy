package ups.pastog

import ups.pastog.user.User;

class EventBase {
	
	Date dateOfStart
	Date dateOfEnd
	String description
	static BelongTo = [user:User]
	static hasMany=[ participants: User]
    static constraints = {

    }
}
