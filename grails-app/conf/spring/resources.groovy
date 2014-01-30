// Place your Spring DSL code here
import grails.plugins.springsecurity.SpringSecurityService
beans = {
	//springSecurityService(SpringSecurityService)
	springConfig.addAlias "springSecurityService", "springSecurityCoreSpringSecurityService"
}
