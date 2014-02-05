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
		//TODO add fields
		//peopleTable { $("div.content table", 0) }
		//personRow { module PersonRow, personRows[it] }
		//personRows(required: false) { peopleTable.find("tbody").find("tr") }
	}
}
/*
class PersonRow extends Module {
	static content = {
		cell { $("td", it) }
		cellText { cell(it).text() }
        cellHrefText{ cell(it).find('a').text() }
		enabled { Boolean.valueOf(cellHrefText(0)) }
		firstName { cellText(1) }
		lastName { cellText(2) }
		showLink(to: ShowPage) { cell(0).find("a") }
	}
}*/