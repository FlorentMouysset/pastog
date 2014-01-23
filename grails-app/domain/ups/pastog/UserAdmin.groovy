package ups.pastog

import org.apache.commons.lang.builder.HashCodeBuilder

class UserAdmin implements Serializable {

        User user
        Admin admin

        boolean equals(other) {
                if (!(other instanceof UserAdmin)) {
                        return false
                }

                other.user?.id == user?.id &&
                        other.admin?.id == admin?.id
        }

        int hashCode() {
                def builder = new HashCodeBuilder()
                if (teacher) builder.append(teacher.id)
                if (admin) builder.append(admin.id)
                builder.toHashCode()
        }

		static UserAdmin get(long userId, long adminId) {
			find 'from UserAdmin where user.id=:userId and admin.id=:adminId',
					[userId: userId, adminId: adminId]
	}

        static UserAdmin create(User user, Admin admin, boolean flush = false) {
                new UserAdmin(user:user, admin: admin).save(flush: flush, insert: true)
        }

        static boolean remove(User user, Admin admin, boolean flush = false) {
                UserAdmin instance = UserAdmin.findByUserAndAdmin(user, admin)
                if (!instance) {
                        return false
                }

                instance.delete(flush: flush)
                true
        }

        static void removeAll(User user) {
                executeUpdate 'DELETE FROM UserAdmin WHERE user=:user', [user: user]
        }

        static void removeAll(Admin admin) {
                executeUpdate 'DELETE FROM UserAdmin WHERE admin=:admin', [admin: admin]
        }

        static mapping = {
                id composite: ['admin', 'user']
                version false
        }
}