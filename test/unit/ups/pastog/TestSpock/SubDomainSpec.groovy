package ups.pastog.TestSpock

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll
import ups.pastog.Domain
import ups.pastog.SubDomain
import ups.pastog.user.User

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@TestFor(SubDomain)
class SubDomainSpec extends Specification {

    @Unroll
    def "test SubDomainTest"() {
        expect:
        def dom = new Domain (title: "Master DL", description: "Developpement logiciel", author: new User(name: "name", secondName: "secondName", email: "email", password: "password", confirmPassword: "confirmPassword") )
        def subdom = new SubDomain(label:label ,domaine: dom)
        (subdom.save() != null )== valide

        where:
        label   | valide
       "IVVQ"   | true
        ""      | false
    }

    /*@Unroll
    def "savingUser"() {

        setup:
        def subDomains = [
                new SubDomain(label:"IVVQ"  ,domaine : new Domain (title: "Master DL", description: "Developpement logiciel", author: new User(name: "name", secondName: "secondName", email: "email", password: "password", confirmPassword: "confirmPassword") )),
                new SubDomain(label:"IVVQ"  ,domaine : new Domain (title: "Master DL", description: "Developpement logiciel", author: new User(name: "name", secondName: "secondName", email: "email", password: "password", confirmPassword: "confirmPassword") ))]
        subDomains*.save(flush: true)

        expect:
        assertEquals 2, SubDomain.list().size()
    }*/

    /*def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
    }*/
}
