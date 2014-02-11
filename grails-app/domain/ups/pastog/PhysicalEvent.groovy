package ups.pastog
class PhysicalEvent {
	
	String place
	EventBase eventBase
	
    static constraints = {
       place blank: false
    }
}
