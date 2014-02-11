import ups.pastog.Domain
import ups.pastog.user.User

class BootStrap {

    def init = { servletContext ->

        User admin  = new User(name: "admin", secondName:"admin1", email: "admin1@mail.fr",passWord:"admin").save()
        User user1  = new User(name: "louhidi", secondName:"amine", email: "admin1@mail.fr",passWord:"123abc").save()

        Domain domain1 = new Domain(title: "Master DL", description: "domaine master1 DL", author: admin).save()
        Domain domain2 = new Domain(title: "Master2 DL", description: "domaine master2 DL", author: user1).save()
    }
    def destroy = {
    }
}
