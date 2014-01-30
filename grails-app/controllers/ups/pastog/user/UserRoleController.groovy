package ups.pastog.user
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken as AuthToken
import org.springframework.security.core.context.SecurityContextHolder as SCH

import ups.pastog.Domain;
import ups.pastog.user.Role;
import ups.pastog.user.User;
import ups.pastog.user.UserRole;

class UserRoleController {
	
	def daoAuthenticationProvider
	
	def register = { UserRegistrationCommand urc ->
		if (!params.register) return
		
		def admin = Role.findByAuthority("ADMIN_ROLE") ?: new Role(authority: "ADMIN_ROLE").save()
		
		if (!urc.hasErrors()) {
			def props = urc.properties
			def user = new User(props)
			
			if (!user.save()) {
				render(view: "../index", model: [userInstance: user])
			}
			
			UserRole.create user, admin
			
			flash.message = message(code: 'app.reg.accept', args: [user.name, user.secondName])
			
			// Log the newly created user in
			def auth = new AuthToken(params.name, params.passWord)
			def authtoken = daoAuthenticationProvider.authenticate(auth)
			SCH.context.authentication = authtoken
			redirect(controller: 'domain', action: 'list')
		} else {
			render(view: "../index", model: [userInstance: urc])
		}
	}
	
	def subscribe = {
		if (!params.domain) return
		
		def currentUser = getAuthenticatedUser()
		def domain = Domain.get(params.domain)
		
		Redirect to the last uri; '/' otherwise
		def targetUri = params.targetUri ?: '/'
		redirect(uri: targetUri)
	}
	
	def unsubscribe = {
		if (!params.domain) return
		
		def currentUser = getAuthenticatedUser()
		def domain= Domain.get(params.domain)
		
		// Redirect to the last uri; '/' otherwise
		def targetUri = params.targetUri ?: '/'
		redirect(uri: targetUri)
	}
	
	def createUser = {
		render(view: "../user/create", model: [userInstance: new User(params)])
	}
	
	def saveUser = { UserRegistrationCommand urc ->
		def admin = Role.findByAuthority("student") ?: new Role(authority: "STUDENT_ROLE").save()
		
		if (!urc.hasErrors()) {
			def props = urc.properties
			def user = new User(props)
			
			if (!user.save()) {
				render(view: "../user/create", model: [userInstance: user])
			}
			
			UserRole.create user, admin
			
			flash.message = message(code: 'app.user.created')
			redirect(controller: 'domain', action: 'list')
		} else {
			render(view: "../user/create", model: [userInstance: urc])
		}
	}
}

class UserRegistrationCommand {
	
	String name
	String secondName
	String email
	String passWord
	String passwordConfirm

	static constraints = {
		email blank: false, email: true, validator: { email, urc ->
			email && User.findByEmail(email) ? 'exists' : true
		}
		passWord blank: false, size: 5..20
		passWordConfirm blank: false, validator: { passWordConfirm, urc ->
			passWordConfirm != urc.passWord ? 'dontmatch' : true
		}
		name blank: false
		secondName blank: false
	}
}
    
