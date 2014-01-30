package ups.pastog

import ups.pastog.user.User;

class Domain {
	
	String title
	String description
	User author
	static hasMany=[ subDomain: SubDomain]

    static constraints = {
		title(unique: true, blank: false)
        description(blank: false, unique : true)
		author(unique : true, blank : false)
    }
}
