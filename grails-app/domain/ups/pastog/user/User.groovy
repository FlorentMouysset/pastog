package ups.pastog.user



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
		
		  
        name(size: 2..20, blank: false, matches: "[a-zA-Z]+")
        secondName(size: 2..20, blank: false, matches: "[a-zA-Z]+")
        email(email:true, nullable:false, blank: false, unique: true)
        password(nullable:false)
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
<<<<<<< HEAD
		boolean isUser() {
			UserRole.get(this.id, RoleEnum.USER_ROLE.id)
		  }
	  


	Set<Role> getAuthorities() {
		UserRole.findAllByUser(this).collect { it.role } as Set
	}

//	def beforeInsert() {
//		encodePassword()
//	}
//
//	def beforeUpdate() {
//		if (isDirty('password')) {
=======
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
>>>>>>> 65983722bfee8bcfd81ccd7ab9a35c341a7191e0
//			encodePassword()
//		}
//	}
//
//	protected void encodePassword() {
//		password = springSecurityService.encodePassword(password)
//	}

	 
    
    /****** CUSTOM ADDITION ******/
   /* String toString() {
        name + " " + secondName
    }*/
}
