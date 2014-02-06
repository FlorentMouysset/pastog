import geb.spock.GebReportingSpec

import spock.lang.*

import pages.*

@Stepwise
class LoginSpec extends GebReportingSpec {
	
	
	def "the login page is the login page"() {
		given:
		to LoginPage
 
		expect:
		at LoginPage
	}
	
	def "given login page you can create a new user"() {
		given:
		to LoginPage
 
		expect:
		at LoginPage
		
		when:
		createUserLink.click()
		
		then:
		at CreateUserPage
	}
}