package ups.pastog
class EventBase {
	
	Date dateOfStart
	Date dateOfEnd
	
	static BelongTo = User
	static hasMany=[ participants: User]
    static constraints = {
    }
}
