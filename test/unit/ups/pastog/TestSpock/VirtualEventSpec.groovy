package ups.pastog.TestSpock

import grails.test.mixin.TestFor
import spock.lang.Specification
import ups.pastog.EventBase
import ups.pastog.Question
import ups.pastog.VirtualEvent

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
        def question1 = Mock(Question)
        def question2 = Mock(Question)

        def v = new VirtualEvent(eventBase : eventBase, questions: [question1, question2])

        (v.save() != null )== true

    }
}
