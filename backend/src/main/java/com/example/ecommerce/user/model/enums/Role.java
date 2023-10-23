package com.example.ecommerce.user.model.enums;


public enum Role {
    USER(1, "User"),
    ADMIN(2, "Admin"),
    MANAGER(3, "Manager");

    private final int roleId;
    private final String roleName;

    Role(int roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    public int getRoleId() {
        return roleId;
    }

    public String getRoleName() {
        return roleName;
    }
}

