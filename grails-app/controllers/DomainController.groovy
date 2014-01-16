import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class DomainController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Domain.list(params), model: [domainInstanceCount: Domain.count()]
    }

    def show(Domain domainInstance) {
        respond domainInstance
    }

    def create() {
        respond new Domain(params)
    }

    @Transactional
    def save(Domain domainInstance) {
        if (domainInstance == null) {
            notFound()
            return
        }

        if (domainInstance.hasErrors()) {
            respond domainInstance.errors, view: 'create'
            return
        }

        domainInstance.save flush: true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'domainInstance.label', default: 'Domain'), domainInstance.id])
                redirect domainInstance
            }
            '*' { respond domainInstance, [status: CREATED] }
        }
    }

    def edit(Domain domainInstance) {
        respond domainInstance
    }

    @Transactional
    def update(Domain domainInstance) {
        if (domainInstance == null) {
            notFound()
            return
        }

        if (domainInstance.hasErrors()) {
            respond domainInstance.errors, view: 'edit'
            return
        }

        domainInstance.save flush: true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Domain.label', default: 'Domain'), domainInstance.id])
                redirect domainInstance
            }
            '*' { respond domainInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Domain domainInstance) {

        if (domainInstance == null) {
            notFound()
            return
        }

        domainInstance.delete flush: true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Domain.label', default: 'Domain'), domainInstance.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'domainInstance.label', default: 'Domain'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
}
