package ups.pastog
import spock.lang.Specification
import ups.pastog.VirtualEvent
import grails.test.mixin.TestFor


/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@TestFor(VirtualEvent)
class VirtualEventSpec extends Specification {


    def setup() {
    }

    def cleanup() {
    }

    void "test virtual event"() {
        expect:
        def eventBase = Mock(EventBase)
        VirtualEvent virtEvent = new VirtualEvent(eventBase)

        (virtEvent.save() != null )== valide

    }
}
