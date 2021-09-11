package tw.com.spring.auth;

import static tw.com.spring.auth.UserRolePermission.*;import java.util.Collections;
import java.util.Set;

import com.google.common.collect.Sets;


public enum UserRole {
	USER(Sets.newHashSet()),
	ADMIN(Sets.newHashSet(ADMIN_READ, ADMIN_WRITE, USER_READ, USER_WRITE));

	private final Set<UserRolePermission> permission;
	
	//PERMISSION IN
	UserRole(Set<UserRolePermission> permission) {
		this.permission = permission;
	}
	
	//PERMISSION OUT
	public Set<UserRolePermission> getPermission() {
		return permission;
	}
	
}
