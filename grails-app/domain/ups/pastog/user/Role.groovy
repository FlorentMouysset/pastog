package ups.pastog.user

class Role {

        String authority

        static mapping = {
                cache true
        }

        static constraints = {
                authority blank: false, unique: true
        }
		enum RoleEnum {
			ADMIN_ROLE(1),
			STUDENT_ROLE(2)
        }
		Long id
		
		void RoleEnum(Long id) {
			this.id = id
		}
		
		Role getRole() {
		Role.get(id)
		 }
}