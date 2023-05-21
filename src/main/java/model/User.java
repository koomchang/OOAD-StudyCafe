package model;

import java.util.Objects;

public class User {

    private final String name;
    private final UserRole role;

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
