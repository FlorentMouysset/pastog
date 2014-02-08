package pages


class LoginPage extends GenericPage {
	//not : "pastog_" "/" "" "pastog_/"
	static url = "/pastog_"
	
	
	static at = {
		title == "PasTog - Homepage"
	}
	
	static content = {
		createUserLink{ $("a", text: "Sign up now!") }
	}
}
