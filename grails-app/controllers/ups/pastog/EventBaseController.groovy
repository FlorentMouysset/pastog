package ups.pastog



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class EventBaseController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond EventBase.list(params), model:[eventBaseInstanceCount: EventBase.count()]
    }

    def show(EventBase eventBaseInstance) {
        respond eventBaseInstance
    }

    def create() {
        respond new EventBase(params)
    }

    @Transactional
    def save(EventBase eventBaseInstance) {
        if (eventBaseInstance == null) {
            notFound()
            return
        }

        if (eventBaseInstance.hasErrors()) {
            respond eventBaseInstance.errors, view:'create'
            return
        }

        eventBaseInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'eventBaseInstance.label', default: 'EventBase'), eventBaseInstance.id])
                redirect eventBaseInstance
            }
            '*' { respond eventBaseInstance, [status: CREATED] }
        }
    }

    def edit(EventBase eventBaseInstance) {
        respond eventBaseInstance
    }

    @Transactional
    def update(EventBase eventBaseInstance) {
        if (eventBaseInstance == null) {
            notFound()
            return
        }

        if (eventBaseInstance.hasErrors()) {
            respond eventBaseInstance.errors, view:'edit'
            return
        }

        eventBaseInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'EventBase.label', default: 'EventBase'), eventBaseInstance.id])
                redirect eventBaseInstance
            }
            '*'{ respond eventBaseInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(EventBase eventBaseInstance) {

        if (eventBaseInstance == null) {
            notFound()
            return
        }

        eventBaseInstance.delete flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'EventBase.label', default: 'EventBase'), eventBaseInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'eventBaseInstance.label', default: 'EventBase'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
