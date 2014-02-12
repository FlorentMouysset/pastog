package ups.pastog.user


import static org.springframework.http.HttpStatus.*

import org.springframework.dao.DataIntegrityViolationException

import ups.pastog.user.Role;
import ups.pastog.user.User;
import ups.pastog.user.UserRole;
import grails.transaction.Transactional

@Transactional(readOnly = true)

class UserController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond User.list(params), model:[userInstanceCount: User.count()]
    }

    def show(User userInstance) {
        respond userInstance
    }

    def create() {
         [userInstance: new User(params)]

    }

    @Transactional
    def save() {
         def userInstance = new User(params)
        if (!userInstance.save(flush: true)) {
            render(view: "create", model: [userInstance: userInstance])
            return
        }
                
                def userRole = Role.findByAuthority("STUDENT_ROLE")
                UserRole.create userInstance, userRole

        flash.message = message(code: 'default.created.message', args: [message(code: 'user.label', default: 'User'), userInstance.id])
        redirect(controller: "domain")
    }

    def edit(Long id) {
		  def userInstance = User.get(id)
        if (!userInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User'), id])
            //redirect(action: "list")
            return
        }


        [userInstance: userInstance]
    }


    @Transactional
    def update(User userInstance) {
        if (userInstance == null) {
            notFound()
            return
        }

        if (userInstance.hasErrors()) {
            respond userInstance.errors, view:'edit'
            return
        }

        userInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'User.label', default: 'User'), userInstance.id])
                redirect userInstance
            }
            '*'{ respond userInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Long id) {
        def userInstance = User.get(id)
        if (!userInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User'), id])
            redirect(action: "list")
            return
        }

        try {
            userInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'user.label', default: 'User'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'user.label', default: 'User'), id])
            redirect(action: "show", id: id)
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'userInstance.label', default: 'User'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
    def register = {
        // new user posts his registration details
        if (request.method == 'POST') {
            // create domain object and assign parameters using data binding
            def u = new User(params)
            if (! u.save()) {
                // validation failed, render registration page again
                flash.error="user.creation.failed"
                return [user:u]
            } else {
                // validate/save ok, store user in session, redirect to classDomain
                flash.message="user.created"
                session.user = u
                redirect(controller:'domain')
            }
        } else if (session.user) {
            // don't allow registration while user is logged in
            redirect(controller:'domain')
        }
    }
 
    def login = {
        if (request.method == 'POST') {
           
			  def u = User.findByNameAndPassword(params.name, params.password)

            if (u) {
                // username and password match -> log in
                session.user = u
                redirect(controller:'domain')
            } else {
                flash.message = "User not found"
                redirect(view:'/layouts/main')
            }
        } else if (session.user) {
            // don't allow login while user is logged in
            redirect(controller:'domain')
        }
    }
 
    def logout = {
        session.invalidate()
        redirect(controller:'logout')
    }
}