package ups.pastog.TestSpock

import grails.test.mixin.TestFor
import grails.test.mixin.TestMixin
import grails.test.mixin.support.GrailsUnitTestMixin
import spock.lang.Specification
import spock.lang.Unroll
import ups.pastog.EventBase
import ups.pastog.PhysicalEvent

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@TestFor(PhysicalEvent)
class PhysicalEventSpec extends Specification {

    @Unroll
    def "test SubDomainTest"() {
        expect:
        def evbase = Mock(EventBase)
        def evPhysique = new PhysicalEvent(place: place ,eventBase:evbase )
        (evPhysique.save() != null )== valide

        where:
        place          | valide
        "BU salle 2"   | true
        ""             | false
    }
}
