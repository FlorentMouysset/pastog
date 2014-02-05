package ups.pastog.TestSpock

import grails.test.mixin.support.GrailsUnitTestMixin
import ups.pastog.Domain
import ups.pastog.user.User

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll
/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
//@TestMixin(GrailsUnitTestMixin)

@TestFor(User)
class TestUserSpec extends Specification {

@Unroll
def "user constraints"() {

	setup:
	def user = new User(name: name,secondName: secondName, email: email, password: password, confirmPassword: confirmPassword)
	
	 user.validate() == valid

	
	where:
     name                      | secondName                | email             | password          | confirmPassword     | valid
	
	 "Name"                    | "secondName"              | "email@email.com" | "password"        |"confirmpassword"    | true
	 "Name0215"                | "secondName"              | "email@email.com" | "password"        |"confirmpassword"    | false
	 "valeurplusgrandequevingt"| "secondName"              | "email@email.com" | "password"        |"confirmpassword"    | false
	 ""                        | "secondName"              | "email@email.com" | "password"        |"confirmpassword"    | false
	 "a"                       | "secondName"              | "email@email.com" | "password"        |"confirmpassword"    | false
	 "Name"                    | "secondName0215"          | "email@email.com" | "password"        |"confirmpassword"    | false
	 "Name"                    | "valeurplusgrandequevingt"| "email@email.com" | "password"        |"confirmpassword"    | false
	 "Name"                    | ""                        | "email@email.com" | "password"        |"confirmpassword"    | false
	 "Name"                    | "a"                       | "email@email.com" | "password"        |"confirmpassword"    | false
	 "Name"                    | "secondName"              | "email"           | "password"        |"confirmpassword"    | false
	 "Name"                    | "secondName"              | ""                | "password"        |"confirmpassword"    | false
	 "Name"                    | "secondName"              | null              | "password"        |""                   | false
	 "Name"                    | "secondName"              | "email@email.com" | ""                |"confirmpassword"    | false
          
}
@Unroll
def "savingUser"() {

	setup:
	def users = [
			new User(name: "firstName", secondName: "secondName", email: "tes1@email.com", password: "password", confirmPassword: "password"),
			new User(name: "firstName", secondName: "secondName", email: "tes2@email.com", password: "password", confirmPassword: "password")]
	users*.save(flush: true)

	expect:
	assertEquals 2, User.list().size()
}

@Unroll
def "testUserHaveSameEmail"() {

	setup:
	def users = [
			new User(name: "brayan", secondName: "adams", email: "bra.ad@toto.com", password: "password", confirmPassword:"password"),
			new User(firstName: "Serena", secondName: "axxin", email:"bra.ad@toto.com", password: "password", confirmPassword:"password")]
	users*.save(flush: true)
	expect:
	assertEquals 1, User.list().size()
}
}