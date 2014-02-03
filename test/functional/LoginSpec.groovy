import geb.spock.GebReportingSpec

import spock.lang.*

import pages.*

@Stepwise
class LoginSpec extends GebReportingSpec {
	
	def "create new user"() {
		when:
		newUserLink.click()
		then:
		at CreatePage
	}
	

	def "test simple"() {
		when:
		to LoginPage
		then:
		1 == 1
	}
	
}