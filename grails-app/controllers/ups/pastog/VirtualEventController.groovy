package ups.pastog



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class VirtualEventController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond VirtualEvent.list(params), model:[virtualEventInstanceCount: VirtualEvent.count()]
    }

    def show(VirtualEvent virtualEventInstance) {
        respond virtualEventInstance
    }

    def create() {
        respond new VirtualEvent(params)
    }

    @Transactional
    def save(VirtualEvent virtualEventInstance) {
        if (virtualEventInstance == null) {
            notFound()
            return
        }

        if (virtualEventInstance.hasErrors()) {
            respond virtualEventInstance.errors, view:'create'
            return
        }

        virtualEventInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'virtualEventInstance.label', default: 'VirtualEvent'), virtualEventInstance.id])
                redirect virtualEventInstance
            }
            '*' { respond virtualEventInstance, [status: CREATED] }
        }
    }

    def edit(VirtualEvent virtualEventInstance) {
        respond virtualEventInstance
    }

    @Transactional
    def update(VirtualEvent virtualEventInstance) {
        if (virtualEventInstance == null) {
            notFound()
            return
        }

        if (virtualEventInstance.hasErrors()) {
            respond virtualEventInstance.errors, view:'edit'
            return
        }

        virtualEventInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'VirtualEvent.label', default: 'VirtualEvent'), virtualEventInstance.id])
                redirect virtualEventInstance
            }
            '*'{ respond virtualEventInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(VirtualEvent virtualEventInstance) {

        if (virtualEventInstance == null) {
            notFound()
            return
        }

        virtualEventInstance.delete flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'VirtualEvent.label', default: 'VirtualEvent'), virtualEventInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'virtualEventInstance.label', default: 'VirtualEvent'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
