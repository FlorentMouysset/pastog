package pages


class SubDomainListPage extends GenericPage {

    static at = {
        title == "SubDomain List"
    }

    static content = {
        logoutLink(to: LoginPage) { $("a", text: "Logout") }
    }
}
