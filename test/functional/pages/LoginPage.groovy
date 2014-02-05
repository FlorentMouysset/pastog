package pages

import geb.Module
import geb.Page

class LoginPage extends Page {
	//not : "pastog_" "/" "" "pastog_/"
	static url = "/pastog_"
	
	
	static at = {
		title == "PasTog - Homepage"
	}
	
	static content = {
		createUserLink{ $("a", text: "Sign up now!") }
	}
}
