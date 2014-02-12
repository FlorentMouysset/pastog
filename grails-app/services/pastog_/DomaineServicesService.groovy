package pastog_

import grails.transaction.Transactional
import ups.pastog.user.User

@Transactional
class DomaineServicesService {

    boolean isAdmin(User user) {
        if(user.name == "Admin")
                return true
        return false
    }


}
