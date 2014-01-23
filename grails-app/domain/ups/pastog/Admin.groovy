package ups.pastog

class Admin {

        String authority

        static mapping = {
                cache true
        }

        static constraints = {
                authority blank: false, unique: true
        }
}