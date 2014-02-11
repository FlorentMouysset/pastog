package pastog_

import grails.transaction.Transactional
import ups.pastog.user.User

@Transactional
class DomainService {

    def serviceMethod() {

    }
    def findUser(String name){
        User user = User.findByName(name)
        return user
    }
}
