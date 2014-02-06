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
        setup:
        def user = new User(name: name, secondName: secondName, email: email, password: password, confirmPassword: confirmPassword)
        def domaine = new Domain (title: title, description: description, author: user )
        domaine.validate() == valid

        where:

        name    | secondName   | email            | password     | confirmPassword   | title | description   |  valid
        "Name"  | "secondName" |"email@email.com" | "password"   |"confirmpassword"  |"title"| "description" | false

    }
    /*def setup() {

   }*/

    /*def cleanup() {
    }*/
}
