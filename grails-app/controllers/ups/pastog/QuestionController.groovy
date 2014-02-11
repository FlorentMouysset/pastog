package ups.pastog



import static org.springframework.http.HttpStatus.*

import grails.transaction.Transactional
import ups.pastog.user.User

@Transactional(readOnly = true)
class QuestionController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Question.list(params), model:[questionInstanceCount: Question.count()]
    }
	
	
	
	static defaultAction = "list"
	@Transactional
	def list(boolean userOnly) {
			User user = (User) springSecurityService.currentUser
	
			if (!springSecurityService.isLoggedIn()) {
				userOnly = false
			}
	
			def QuestionList = AllService.listQuestion(user, userOnly)
			def totalCount = QuestionList.size()
	
			int offset = (params.offset ?: 0) as Integer
			int max = (params.max ?: 4) as Integer
	
			QuestionList = QuestionList.subList(
					offset,
					(offset + max < totalCount) ? (offset + max) : totalCount
			)
	
			return [
					QuestionList: QuestionList,
					totalCount: totalCount,
					user: user,
					userOnly: userOnly
			]
		}
   
		
	def show(Question questionInstance) {
        respond questionInstance
    }

    def create() {
        respond new Question(params)
    }


    @Transactional
    def save(Question questionInstance) {
        if (questionInstance == null) {
            notFound()
            return
        }

        if (questionInstance.hasErrors()) {
            respond questionInstance.errors, view:'create'
            return
        }

        questionInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'questionInstance.label', default: 'Question'), questionInstance.id])
                redirect questionInstance
            }
            '*' { respond questionInstance, [status: CREATED] }
        }
    }

    def edit(Question questionInstance) {
        respond questionInstance
    }

    @Transactional
    def update(Question questionInstance) {
        if (questionInstance == null) {
            notFound()
            return
        }

        if (questionInstance.hasErrors()) {
            respond questionInstance.errors, view:'edit'
            return
        }

        questionInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Question.label', default: 'Question'), questionInstance.id])
                redirect questionInstance
            }
            '*'{ respond questionInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Question questionInstance) {

        if (questionInstance == null) {
            notFound()
            return
        }

        questionInstance.delete flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Question.label', default: 'Question'), questionInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'questionInstance.label', default: 'Question'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
