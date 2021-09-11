package tw.com.spring.auth;

public enum UserRolePermission {
	USER_READ("user:read"),
	USER_WRITE("user:write"),
	ADMIN_READ("admin:read"),
	ADMIN_WRITE("admin:write");
	
	private final String permission;

	UserRolePermission (String permission) {
		this.permission = permission;
	}

	public String getPermission() {
		return permission;
	}
	
	
}
