import geb.spock.GebReportingSpec

import spock.lang.*

import pages.*

@Stepwise
class PersonCRUDSpec extends GebReportingSpec {
	
	def "there are no people"() {
		when:
		to ListPage
		then:
		personRows.size() == 0
	}
	

}