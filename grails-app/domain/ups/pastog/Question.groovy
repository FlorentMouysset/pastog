package ups.pastog
class Question {
	String enunciated
	User user
	static hasMany=[ reponse: Response]

    static constraints = {
    }
}
