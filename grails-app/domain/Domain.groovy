class Domain {
	
	String title
	String description
	User autor
	static hasMany=[ subDomain: SubDomain]

    static constraints = {
		title{ unique: true}
		
    }
}
