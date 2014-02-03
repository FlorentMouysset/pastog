package pages

import geb.Module

class LoginPage extends ScaffoldPage {
	static url = "pastog_/"
	
	static at = {
		title ==~ /PasTog - Homepage/
	}
	
	static content = {
		newUserLink(to: CreatePage) { $("a", text: "Sign up now!") }
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