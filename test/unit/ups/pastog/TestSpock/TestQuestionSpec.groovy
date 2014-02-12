package ups.pastog.TestSpock

import grails.test.mixin.TestMixin
import grails.test.mixin.support.GrailsUnitTestMixin
import spock.lang.Specification
import spock.lang.Unroll;
import ups.pastog.Question
import ups.pastog.user.User;

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@TestMixin(GrailsUnitTestMixin)
class TestQuestionSpec extends Specification {

     @Unroll
    def "test QuestionTest"() {
		setup:
		def question= new Question(enunciated: "enunciated", user: "user")
		def usera=new User("test", "test", "testtest@yahoo.fr", "1234test", "1234test") 
		
		
		question.validate() == valid
		
		where:
		enuciated                | user      |  valid 
		"c'est juste un test"    |usera      | true 
		""                       |usera      | false
		"testa"                  |null       | false
		
		
     }
	
}
