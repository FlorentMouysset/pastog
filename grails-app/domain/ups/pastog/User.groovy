package ups.pastog
class User {

	String name
	String secondName
	String email
	String passWord
	
    static constraints = {
		
		name(blank:false)
		secondName(blank:false)
		email(blank:false, email:true, unique: true)
		passWord(blank:false, password: true)
		
    }
}
