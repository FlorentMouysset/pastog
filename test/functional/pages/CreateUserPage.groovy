package pages

import geb.Page

class CreateUserPage extends Page {

	static url = "/pastog_/user/register"
	
	static at = {
		title ==~ /POP.+/
	}
	
	static content = {
		firstName{ $("input", id:"name") }
		surname{ $("input", id:"secondName") }
		password{ $("input", id:"password") }
		confirmPassword{ $("input", id:"confirmPassword") }
		email{ $("input", id:"email") }
		createUserButton(to: DomainListPage) { submitButton() }
	}

}