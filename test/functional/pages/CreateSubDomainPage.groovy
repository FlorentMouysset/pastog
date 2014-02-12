package pages


class CreateSubDomainPage extends GenericPage {
    static url = "/pastog_/subDomain/create"

    static at = {
        title ==~ /POP.+/
    }

    static content = {
        label{ $("input", id:"label") }
        createUserButton { create() }
    }

}
