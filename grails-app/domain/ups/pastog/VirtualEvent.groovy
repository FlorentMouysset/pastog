package ups.pastog
class VirtualEvent {

	EventBase eventBase
	static hasMany=[ questions: Question]
	
    static constraints = {

    }
}
