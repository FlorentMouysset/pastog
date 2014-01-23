import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class SubDomainController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond SubDomain.list(params), model: [subDomainInstanceCount: SubDomain.count()]
    }

    def show(SubDomain subDomainInstance) {
        respond subDomainInstance
    }

    def create() {
        respond new SubDomain(params)
    }

    @Transactional
    def save(SubDomain subDomainInstance) {
        if (subDomainInstance == null) {
            notFound()
            return
        }

        if (subDomainInstance.hasErrors()) {
            respond subDomainInstance.errors, view: 'create'
            return
        }

        subDomainInstance.save flush: true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'subDomainInstance.label', default: 'SubDomain'), subDomainInstance.id])
                redirect subDomainInstance
            }
            '*' { respond subDomainInstance, [status: CREATED] }
        }
    }

    def edit(SubDomain subDomainInstance) {
        respond subDomainInstance
    }

    @Transactional
    def update(SubDomain subDomainInstance) {
        if (subDomainInstance == null) {
            notFound()
            return
        }

        if (subDomainInstance.hasErrors()) {
            respond subDomainInstance.errors, view: 'edit'
            return
        }

        subDomainInstance.save flush: true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'SubDomain.label', default: 'SubDomain'), subDomainInstance.id])
                redirect subDomainInstance
            }
            '*' { respond subDomainInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(SubDomain subDomainInstance) {

        if (subDomainInstance == null) {
            notFound()
            return
        }

        subDomainInstance.delete flush: true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'SubDomain.label', default: 'SubDomain'), subDomainInstance.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'subDomainInstance.label', default: 'SubDomain'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
}
