package pages


class DomainListPage extends GenericPage {

	static at = {
		title == "Domain List"
	}
	
	static content = {
		logoutLink(to: LoginPage) { $("a", text: "Logout") }
	}

}