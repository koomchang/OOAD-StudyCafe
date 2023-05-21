package model;

import exception.UserRoleException;

public enum UserRole {
    ADMIN(1),
    BASIC(2);

    private final int roleNumber;

    UserRole(int roleNumber) {
        this.roleNumber = roleNumber;
    }

    public static UserRole of(int roleNumber) {
        if (roleNumber == 1) {
            return ADMIN;
        } else if (roleNumber == 2) {
            return BASIC;
        }
        throw new UserRoleException("1 또는 2를 입력해주세요.");
    }
}
