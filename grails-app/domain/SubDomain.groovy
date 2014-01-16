class SubDomain {
	User user
	static belongsTo = Domain

	static hasMany=[ virtualEvent: VirtualEvent,  physicalEvent: PhysicalEvent ]
	
	    static constraints = {
    }
}
