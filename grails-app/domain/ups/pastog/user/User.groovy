package ups.pastog.user

import grails.plugins.springsecurity.SpringSecurityService;

class User {

	transient springSecurityService
	
	String name
	String secondName
	String email
	String password
	String confirmPassword
	
	// transients
	static transients = ['password', 'confirmPassword']
	
    static constraints = {
		
		name(blank:false)
		secondName(blank:false)
		email(blank:false, email:true, unique: true)
		password  blank:false, size:5..15, matches:/[\S]+/, validator:{ val, obj ->
            if (obj.password != obj.confirmPassword)
                return 'user.password.dontmatch'
        }
    }
		static mapping = {
			password column: '`password`'
		}
		/**
		 *
		 * @return true if the user is a admin
		 */
		/*boolean isAdmin() {
		  UserRole.get(this.id, RoleEnum.ADMIN_ROLE.id)
		}*/
	  
		/**
		 *
		 * @return true if the user is other student
		 */
		/*boolean isStudent() {
			UserRole.get(this.id, RoleEnum.STUDENT_ROLE.id)
		  }
	  
		Set<Role> getAuthorities() {
		  UserRole.findAllByUser(this).collect { it.role } as Set
		}*/
	  
//		def beforeInsert() {
//		  encodePassword()
//		}
//	  
//		def beforeUpdate() {
//		  if (isDirty('passWord')) {
//			encodePassword()
//		  }
//		}
//	  
//		protected void encodePassword() {
//		  password = springSecurityService.encodePassword(password)
//		}
	 
    
    /****** CUSTOM ADDITION ******/
   /* String toString() {
        name + " " + secondName
    }*/
}
