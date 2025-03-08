package com.joborbit.joborbit.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "user_type")
public class UsersType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Best for MySQL
    private int userTypeId;

    private String userTypeName;

    @OneToMany(mappedBy = "userTypeId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Users> users;

    // Default constructor required by JPA
    public UsersType() {}

    public UsersType(int userTypeId, String userTypeName, List<Users> users) {
        this.userTypeId = userTypeId;
        this.userTypeName = userTypeName;
        this.users = users;
    }

    public int getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(int userTypeId) {
        this.userTypeId = userTypeId;
    }

    public String getUserTypeName() {
        return userTypeName;
    }

    public void setUserTypeName(String userTypeName) {
        this.userTypeName = userTypeName;
    }

    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "UsersType{" +
                "userTypeId=" + userTypeId +
                ", userTypeName='" + userTypeName + '\'' +
                '}';
    }
}
