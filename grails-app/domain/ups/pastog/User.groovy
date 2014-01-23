package ups.pastog

import grails.plugins.springsecurity.SpringSecurityService;

class User {

	transient springSecurityService
	
	String name
	String secondName
	String email
	String passWord
	
    static constraints = {
		
		name(blank:false)
		secondName(blank:false)
		email(blank:false, email:true, unique: true)
		passWord(blank:false, password: true)
		
    }
	static mapping = {
		passWord column: '`passWord`'
}

Set<Admin> getAuthorities() {
		UserAdmin.findAllByUser(this).collect { it.admin } as Set
}


        def beforeInsert() {
                encodePassword()
        }

        def beforeUpdate() {
                if (isDirty('password')) {
                        encodePassword()
                }
        }

        protected void encodePassword() {
                passWord = springSecurityService.encodePassword(passWord)
        }
    
    /****** CUSTOM ADDITION ******/
    String toString() {
        name + " " + secondName
    }
}
