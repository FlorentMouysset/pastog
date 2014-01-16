package ups.pastog



import grails.test.mixin.*
import spock.lang.*

@TestFor(PhysicalEventController)
@Mock(PhysicalEvent)
class PhysicalEventControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void "Test the index action returns the correct model"() {

        when:"The index action is executed"
            controller.index()

        then:"The model is correct"
            !model.physicalEventInstanceList
            model.physicalEventInstanceCount == 0
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            controller.create()

        then:"The model is correctly created"
            model.physicalEventInstance!= null
    }

    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            def physicalEvent = new PhysicalEvent()
            physicalEvent.validate()
            controller.save(physicalEvent)

        then:"The create view is rendered again with the correct model"
            model.physicalEventInstance!= null
            view == 'create'

        when:"The save action is executed with a valid instance"
            response.reset()
            populateValidParams(params)
            physicalEvent = new PhysicalEvent(params)

            controller.save(physicalEvent)

        then:"A redirect is issued to the show action"
            response.redirectedUrl == '/physicalEvent/show/1'
            controller.flash.message != null
            PhysicalEvent.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def physicalEvent = new PhysicalEvent(params)
            controller.show(physicalEvent)

        then:"A model is populated containing the domain instance"
            model.physicalEventInstance == physicalEvent
    }

    void "Test that the edit action returns the correct model"() {
        when:"The edit action is executed with a null domain"
            controller.edit(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the edit action"
            populateValidParams(params)
            def physicalEvent = new PhysicalEvent(params)
            controller.edit(physicalEvent)

        then:"A model is populated containing the domain instance"
            model.physicalEventInstance == physicalEvent
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when:"Update is called for a domain instance that doesn't exist"
            controller.update(null)

        then:"A 404 error is returned"
            response.redirectedUrl == '/physicalEvent/index'
            flash.message != null


        when:"An invalid domain instance is passed to the update action"
            response.reset()
            def physicalEvent = new PhysicalEvent()
            physicalEvent.validate()
            controller.update(physicalEvent)

        then:"The edit view is rendered again with the invalid instance"
            view == 'edit'
            model.physicalEventInstance == physicalEvent

        when:"A valid domain instance is passed to the update action"
            response.reset()
            populateValidParams(params)
            physicalEvent = new PhysicalEvent(params).save(flush: true)
            controller.update(physicalEvent)

        then:"A redirect is issues to the show action"
            response.redirectedUrl == "/physicalEvent/show/$physicalEvent.id"
            flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when:"The delete action is called for a null instance"
            controller.delete(null)

        then:"A 404 is returned"
            response.redirectedUrl == '/physicalEvent/index'
            flash.message != null

        when:"A domain instance is created"
            response.reset()
            populateValidParams(params)
            def physicalEvent = new PhysicalEvent(params).save(flush: true)

        then:"It exists"
            PhysicalEvent.count() == 1

        when:"The domain instance is passed to the delete action"
            controller.delete(physicalEvent)

        then:"The instance is deleted"
            PhysicalEvent.count() == 0
            response.redirectedUrl == '/physicalEvent/index'
            flash.message != null
    }
}
