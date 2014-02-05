import geb.spock.GebReportingSpec

import spock.lang.*

import pages.*
import gpages.*

@Stepwise
class Login2Spec extends GebReportingSpec {
	
	
	/*def "the login page is the login page"() {
		given:
		to LoginPage
 
		expect:
		at LoginPage
	}
	*/
	
	def "my test geb 1"() {
		given:
		to CreateUserPage		
		
		when:
		//$("#enabled").click()
		firstName = "Jean"
		surname = "Paul"
		password = "azerty"
		confirmPassword = "azerty"
		email = "Jean.Paul@monMail.pays"
		
		createUserButton.click()
		then:
		at DomainListPage
	}
	
/*	def "create new user"() {
		when:
		newUserLink.click()
		then:
		at CreatePage
	}*/
	

	/*def "test simple"() {
		when:
		to LoginPage
		then:
		1 == 1
	}*/
	
	
}