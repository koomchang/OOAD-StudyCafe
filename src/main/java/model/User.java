package model;

public class User {

    private static int nextId = 1;
    private final int id;
    private final String name;
    private final UserRole role;

    public User(String name, UserRole role) {
        this.id = nextId++;
        this.name = name;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isAdmin() {
        return role == UserRole.ADMIN;
    }
}
