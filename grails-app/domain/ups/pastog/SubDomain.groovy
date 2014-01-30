package ups.pastog
class SubDomain {

	User user
    String label
	static belongsTo = Domain

	static hasMany=[ virtualEvent: VirtualEvent,  physicalEvent: PhysicalEvent ]
	
	    static constraints = {

    }
}
