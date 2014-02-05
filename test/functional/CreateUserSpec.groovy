import geb.spock.GebReportingSpec

import spock.lang.*

import pages.*

@Stepwise
class CreateUserSpec extends GebReportingSpec {
	
	def "create user ok"() {
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
	
	
}