import geb.spock.GebSpec
import gpages.*
 
class GoogleWikipediaSpec extends GebSpec {
 
    def "first result for wikipedia search should be wikipedia"() {
        given:
        to GoogleHomePage
 
        expect:
        at GoogleHomePage
 
        when:
        search.field.value("wikipedia") //Wikipedia, the free encyclopedia
 
        then:
        waitFor { at GoogleResultsPage }
 
        and:
        firstResultLink.text() == "Wikipedia"
 
        when:
        firstResultLink.click()
 
        then:
        waitFor { at WikipediaPage }
    }
}