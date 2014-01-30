package ups.pastog

import ups.pastog.user.User;

class Response {
	
	Question question
	String response
	User user

    static constraints = {
		
		response(blank:false)
    }
}
