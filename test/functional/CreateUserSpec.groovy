import geb.spock.GebReportingSpec

import spock.lang.*

import pages.*

@Stepwise
class CreateUserSpec extends GebReportingSpec {
	

def "create user ok"() {
		given:
		waitFor{ to CreateUserPage }
		
		when:
		$("#enabled").click()
		firstName = "Jean"
		surname = "Paul"
		password = "azerty"
		confirmPassword = "azerty"
		email = "Jean.Paul@monMail.pays"
		
		createUserButton.click()
		then:
		waitFor{ at DomainListPage }
		and:
		infoMessage == "user.created"
		
		when:
		logoutLink.click()
		then:
		waitFor{ at LoginPage }
		
	}
	


	def "don't match PW and retry successfully"() {
		given:
		waitFor{ to CreateUserPage }
		
		when:
		$("#enabled").click()
		firstName = "Pierre"
		surname = "Jaques"
		password = "azerty"
		confirmPassword = "aaaaa"
		email = "Pierre.Jaques@monMail.pays"
		
		createUserButton.click()
		then:
		at CreateUserPage
		and:
		errorMessage == "Passwords dont match"
		
		
		//retry
		when:
		$("#enabled").click()
		password = "azerty"
		confirmPassword = "azerty"
		
		createUserButton.click()
		then:
		waitFor{ at DomainListPage }
		
		when:
		logoutLink.click()
		then:
		waitFor{ at LoginPage }
	}

	
	def "email ready use and retry successfully"() {
		given:
		waitFor{ to CreateUserPage }
		
		when:
		$("#enabled").click()
		firstName = "Jean"
		surname = "Paul"
		password = "azerty"
		confirmPassword = "azerty"
		email = "Jean.Paul@monMail.pays"
		
		createUserButton.click()
		then:
		at CreateUserPage
		and:
		errorMessage == "Property [email] of class [class ups.pastog.user.User] with value [Jean.Paul@monMail.pays] must be unique"
		
		//retry
		when:
		$("#enabled").click()
		password = "azerty"
		confirmPassword = "azerty"
		email = "Jean2.Paul2@monMail.pays"
		
		createUserButton.click()
		then:
		waitFor{ at DomainListPage }
		
		when:
		logoutLink.click()
		then:
		waitFor{ at LoginPage }
	}
	
}