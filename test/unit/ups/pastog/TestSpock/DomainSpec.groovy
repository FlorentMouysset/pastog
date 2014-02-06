package ups.pastog.TestSpock

import grails.test.mixin.TestFor
import grails.test.mixin.TestMixin
import grails.test.mixin.support.GrailsUnitTestMixin
import spock.lang.Specification
import spock.lang.Unroll
import ups.pastog.Domain
import ups.pastog.TestSpock.TestUserSpec
import ups.pastog.user.User

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@TestFor(Domain)
class DomainSpec extends Specification {
    @Unroll
    def "test DomainTest"() {
        expect:
        def user = new User(name: "name", secondName: "secondName", email: "email", password: "password", confirmPassword: "confirmPassword")
        def dom = new Domain (title: title, description: description, author: user )
        (dom.save() != null )== valide

        where:
        title | description   | valide
        "title1"| "description1"| true
        "" | "description"| false
        "title2"| ""| false
        ""| ""| false
        ""| ""| false
        }
    /*def setup() {

   }*/

    /*def cleanup() {
    }*/
}
