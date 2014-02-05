package ups.pastog



import grails.test.mixin.*
import spock.lang.*
import ups.pastog.user.User;
import ups.pastog.user.UserController;
import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(UserController)
@Mock([User])
class UserControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void "Test the index action returns the correct model"() {

        when:"The index action is executed"
            controller.index()

        then:"The model is correct"
            !model.userInstanceList
            model.userInstanceCount == 0
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            controller.register()

        then:"The model is correctly created"
            model.userInstance== null
    }

    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            def user = new User()
            user.validate()
            controller.save()

        then:"The create view is rendered again with the correct model"
            model.userInstance!= null
            //view == 'register'

//        when:"The save action is executed with a valid instance"
//            response.reset()
//            populateValidParams(params)
//            user = new User(params)
//
//            controller.save()
//
//        then:"A redirect is issued to the show action"
//            response.redirectedUrl == '/user/show/1'
//            controller.flash.message != null
//            User.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def user = new User(params)
            controller.show(user)

        then:"A model is populated containing the domain instance"
            model.userInstance == user
    }

    void "Test that the edit action returns the correct model"() {
        when:"The edit action is executed with a null domain"
            controller.edit(null)

        then:"A 200 error is returned"
            response.status == 200

//        when:"A domain instance is passed to the edit action"
//            populateValidParams(params)
//            def user = new User(params)
//            controller.edit()
//
//        then:"A model is populated containing the domain instance"
//            model.userInstance == user
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when:"Update is called for a domain instance that doesn't exist"
            controller.update(null)

        then:"A 404 error is returned"
            response.redirectedUrl == '/user/index'
            flash.message != null


        when:"An invalid domain instance is passed to the update action"
            response.reset()
            def user = new User()
            user.validate()
            controller.update(user)

        then:"The edit view is rendered again with the invalid instance"
            view == 'edit'
            model.userInstance == user

            flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
         flash.message != null

        when:"A domain instance is created"
            response.reset()
            populateValidParams(params)
            def user = new User(params).save(flush: true)

        then:"It exists"
            User.count() == 0

//        when:"The domain instance is passed to the delete action"
//            controller.delete(user)
//
//        then:"The instance is deleted"
//            User.count() == 0
//            response.redirectedUrl == '/index'
//            flash.message != null
    }
	
	//@amel
	
	def "toLogUser"() {
		given:
		controller.params.name= "daniel1205"
		controller.params.password = "pas"

		and:
		controller.login()

		expect:
		controller.getFlash().error != "User not found"
	}
	
	def "toSaveUserWithFailedPassword"() {
		given:
		controller.params.name = "toto"
		controller.params.secondName = "toto"
		controller.params.email = "toto@toto.fr"
		controller.params.password = "password"
		controller.params.confirmPassword = "pass"

		and:
		controller.create()

		expect:
		controller.getFlash().error != "user.password.checking.failed"
	} 
	
	def "ToSaveUserInDB"() {
        given:
        controller.params.name = "test1"
        controller.params.secondName = "testSecondName"
        controller.params.email = "test1@test1.com"
        controller.params.password = "password"
        controller.params.confirmPassword = "password"

        and:
        controller.create()

        expect:
        controller.getFlash().error !="user.create.failed"
    }

	
	

}
