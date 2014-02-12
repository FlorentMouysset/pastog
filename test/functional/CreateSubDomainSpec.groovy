import geb.spock.GebReportingSpec
import pages.CreateSubDomainPage
import pages.LoginPage
import pages.SubDomainListPage
import spock.lang.Stepwise


@Stepwise
class CreateSubDomainSpec extends GebReportingSpec{

    def "the create page is the create page"() {
        given:
        to CreateSubDomainPage

        expect:
        at CreateSubDomainPage
    }


    def "create subdomain ok"() {
        given:
        waitFor{ to CreateSubDomainPage }

        when:
        $("#enabled").click()
        label = "IVVQ"


        createUserButton.click()
        then:
        waitFor{ at SubDomainListPage }

        when:
        logoutLink.click()
        then:
        waitFor{ at LoginPage }

    }
}

