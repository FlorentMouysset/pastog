package pages

class CreatePage extends ScaffoldPage {

	static at = {
		title ==~ /POP.+/
	}
	
	static content = {
	//	createButton(to: ShowPage) { create() }
	}

}