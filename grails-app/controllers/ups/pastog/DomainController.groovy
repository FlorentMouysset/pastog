package ups.pastog

import sun.rmi.runtime.Log
import ups.pastog.user.User
import pastog_.DomainService.*

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class DomainController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Domain.list(params), model:[domainInstanceCount: Domain.count()]
    }

    def show(Domain domainInstance) {
        respond domainInstance
    }

    def create()
    {
        respond new Domain(params)
    }
    //{

        //User userAdmin = User.findByName("admin")
        /*Voir si l'utilisateur est un administrateur*/
         //def userInstance = User.get(id)
        /*si l'utilisateur est un admin*/
        /*if(userInstance.name.equals( userAdmin.name ) == 0 ){
            Domain domain = new Domain(title: "title", description: "description", author: userInstance)
            respond domain
        }
        else
        {
            flash.message ="Cette action est réserver au administrateur"
            redirect(action:"create")
        }

    }*/

    def newSubDomain(long id)
    {

        def domain = session["domain"]
        def domainInstance = Domain.findById(id)
        redirect(controller: "subDomain", action: "create", params: params.id)

        /*if(domainInstance == null)
        {
            flash.message = "domainInstance null"
            redirect(controller: "domain", action: "create")
        }*/
        /*session["domain"] = domainInstance
        assert  domainInstance == session.domain
        if(session.domain == null)
        {
            flash.message = "session domain null"
            redirect(action: "create")
        }*/

        /*if (domainInstance == null) {
            flash.message = "instance non null"
            redirect(view:'create')
        }
        else{
            def domain = session["domain"]
            session.domain = domainInstance
            assert  domainInstance == session.domain

            redirect(controller: "SubDomain", action: "create")
        }*/

    }

    @Transactional
    def save() {
        Domain domainInstance = new Domain()
        domainInstance.save()
        if (domainInstance == null) {
            notFound()
            return
        }

        domainInstance.author =  session.user
        domainInstance.title = params.title
        domainInstance.description = params.description
        domainInstance.save()
       	 render(view: "index", model: [domainInstance: domainInstance])

        domainInstance.save(flush:true)

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
            respond domainInstance.errors, view:'edit'
            return
        }

        domainInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Domain.label', default: 'Domain'), domainInstance.id])
                redirect domainInstance
            }
            '*'{ respond domainInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Domain domainInstance) {

        if (domainInstance == null) {
            notFound()
            return
        }

        domainInstance.delete flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Domain.label', default: 'Domain'), domainInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'domainInstance.label', default: 'Domain'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
