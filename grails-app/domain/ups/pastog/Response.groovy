package ups.pastog
class Response {
	
	Question question
	String response
	User user

    static constraints = {
		
		response(blank:false)
    }
}
