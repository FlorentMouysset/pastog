package ups.pastog

import ups.pastog.user.User;

class Domain {
	
	String title
	String description
	User autor
	static hasMany=[ subDomain: SubDomain]

    static constraints = {
		title{ unique: true}
		
    }
}
