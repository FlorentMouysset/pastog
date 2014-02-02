package ups.pastog



import grails.test.mixin.*
import spock.lang.*
import ups.pastog.user.User

@TestFor(SubDomainController)
@Mock(SubDomain)
class SubDomainControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
        params["label"] = "master2 DL"
        params["user"] = new User(name: "mehdi", secondName:"but", email: "mehdi@hotmail.fr",passWord:"azerty")
    }

    void "Test the index action returns the correct model"() {

        when:"The index action is executed"
            controller.index()

        then:"The model is correct"
            !model.subDomainInstanceList
            model.subDomainInstanceCount == 0
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            controller.create()

        then:"The model is correctly created"
            model.subDomainInstance!= null
    }

    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            def subDomain = new SubDomain()
            subDomain.validate()
            controller.save(subDomain)

        then:"The create view is rendered again with the correct model"
            model.subDomainInstance!= null
            view == 'create'

        when:"The save action is executed with a valid instance"
            response.reset()
            populateValidParams(params)
            subDomain = new SubDomain(params)

            controller.save(subDomain)

        then:"A redirect is issued to the show action"
            response.redirectedUrl == '/subDomain/show/1'
            controller.flash.message != null
            SubDomain.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def subDomain = new SubDomain(params)
            controller.show(subDomain)

        then:"A model is populated containing the domain instance"
            model.subDomainInstance == subDomain
    }

    void "Test that the edit action returns the correct model"() {
        when:"The edit action is executed with a null domain"
            controller.edit(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the edit action"
            populateValidParams(params)
            def subDomain = new SubDomain(params)
            controller.edit(subDomain)

        then:"A model is populated containing the domain instance"
            model.subDomainInstance == subDomain
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when:"Update is called for a domain instance that doesn't exist"
            controller.update(null)

        then:"A 404 error is returned"
            response.redirectedUrl == '/subDomain/index'
            flash.message != null


        when:"An invalid domain instance is passed to the update action"
            response.reset()
            def subDomain = new SubDomain()
            subDomain.validate()
            controller.update(subDomain)

        then:"The edit view is rendered again with the invalid instance"
            view == 'edit'
            model.subDomainInstance == subDomain

        when:"A valid domain instance is passed to the update action"
            response.reset()
            populateValidParams(params)
            subDomain = new SubDomain(params).save(flush: true)
            controller.update(subDomain)

        then:"A redirect is issues to the show action"
            response.redirectedUrl == "/subDomain/show/$subDomain.id"
            flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when:"The delete action is called for a null instance"
            controller.delete(null)

        then:"A 404 is returned"
            response.redirectedUrl == '/subDomain/index'
            flash.message != null

        when:"A domain instance is created"
            response.reset()
            populateValidParams(params)
            def subDomain = new SubDomain(params).save(flush: true)

        then:"It exists"
            SubDomain.count() == 1

        when:"The domain instance is passed to the delete action"
            controller.delete(subDomain)

        then:"The instance is deleted"
            SubDomain.count() == 0
            response.redirectedUrl == '/subDomain/index'
            flash.message != null
    }
}
