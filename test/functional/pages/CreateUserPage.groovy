package pages


class CreateUserPage extends GenericPage {

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
		//createUserButton(to: DomainListPage) { submitButton() }
		createUserButton { submitButton() }
	}

}