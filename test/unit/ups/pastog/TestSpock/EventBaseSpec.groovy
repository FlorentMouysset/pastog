package ups.pastog.TestSpock

import grails.test.mixin.TestFor
import grails.test.mixin.TestMixin
import grails.test.mixin.support.GrailsUnitTestMixin
import spock.lang.Specification
import spock.lang.Unroll
import ups.pastog.EventBase
import ups.pastog.SubDomain
import ups.pastog.user.User

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@TestFor(EventBase)
class EventBaseSpec extends Specification {

    @Unroll
    def "test EventBaseTest"() {
        expect:
        def subdom = Mock(SubDomain)
        def author = Mock(User)
        def event = new EventBase(description:desc , dateOfStart:ds , dateOfEnd:de , subdomain:subdom , author:author)
        (event.save() != null )== valide

        where:
        desc                  | ds            | de           | valide
        "revision"            | "01/01/2013"  | "02/01/2013" | true
        "correction controle" | "02/01/2013"  | "01/01/2013" | false
        ""                    | "01/01/2013"  | "02/01/2013" | false
        "revision"            | "01/01/2013"  | "01/01/2013" | false


    }
}
