package model;

import java.util.Objects;

public class User {

    private final String name;
    private final UserRole role;
    private boolean isLogin = false;

    public User(String name, UserRole role) {
        this.name = name;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public boolean isAdmin() {
        return role == UserRole.ADMIN;
    }

    public boolean isLogin() {
    	return isLogin;
    }

    public void login() {
    	isLogin = true;
    }

    public void logout() {
    	isLogin = false;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(name, user.name) && role == user.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, role);
    }
}
