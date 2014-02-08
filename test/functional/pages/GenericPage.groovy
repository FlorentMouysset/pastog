package pages

import geb.Page

class GenericPage extends Page {

	
	static content = {
		errorMessage { $("div.errors").text() }
		infoMessage { $("div.message").text() }
	}
	
}
