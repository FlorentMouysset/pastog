package ups.pastog

import ups.pastog.user.User;

class EventBase {
	
	Date dateOfStart
	Date dateOfEnd
	
	static BelongTo = User
	static hasMany=[ participants: User]
    static constraints = {
    }
}
