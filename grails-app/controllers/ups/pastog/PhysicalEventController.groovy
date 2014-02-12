package ups.pastog



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class PhysicalEventController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond PhysicalEvent.list(params), model:[physicalEventInstanceCount: PhysicalEvent.count()]
    }

    def show(PhysicalEvent physicalEventInstance) {
        respond physicalEventInstance
    }

    def create() {
        respond new PhysicalEvent(new EventBase(description:params.description,dateOfStart:params.dateOfStart,dateOfEnd:params.dateOfEnd,author:session.user),place:params.place)
    }

    @Transactional
    def save(PhysicalEvent physicalEventInstance) {
        if (physicalEventInstance == null) {
            notFound()
            return
        }

        if (physicalEventInstance.hasErrors()) {
            respond physicalEventInstance.errors, view:'create'
            return
        }

        physicalEventInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'physicalEventInstance.label', default: 'PhysicalEvent'), physicalEventInstance.id])
                redirect physicalEventInstance
            }
            '*' { respond physicalEventInstance, [status: CREATED] }
        }
    }

    def edit(PhysicalEvent physicalEventInstance) {
        respond physicalEventInstance
    }

    @Transactional
    def update(PhysicalEvent physicalEventInstance) {
        if (physicalEventInstance == null) {
            notFound()
            return
        }

        if (physicalEventInstance.hasErrors()) {
            respond physicalEventInstance.errors, view:'edit'
            return
        }

        physicalEventInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'PhysicalEvent.label', default: 'PhysicalEvent'), physicalEventInstance.id])
                redirect physicalEventInstance
            }
            '*'{ respond physicalEventInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(PhysicalEvent physicalEventInstance) {

        if (physicalEventInstance == null) {
            notFound()
            return
        }

        physicalEventInstance.delete flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'PhysicalEvent.label', default: 'PhysicalEvent'), physicalEventInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'physicalEventInstance.label', default: 'PhysicalEvent'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
