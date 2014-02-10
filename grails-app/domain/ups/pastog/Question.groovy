package ups.pastog

import ups.pastog.user.User;

class Question {
	
	String enunciated
	User user
	static hasMany=[ reponse: Response]
	//static belongsTo = [student: User]

    static constraints = {
    }
}
