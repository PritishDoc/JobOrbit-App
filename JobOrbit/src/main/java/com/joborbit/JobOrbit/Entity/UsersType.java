package com.joborbit.JobOrbit.Entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "users_type") // Ensure table name matches DB
public class UsersType { // Removed unnecessary inner class

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int usersTypeId;  // Fixed field name consistency

    @Column(nullable = false, unique = true)
    private String userTypeName;

    @OneToMany(mappedBy = "usersType", cascade = CascadeType.ALL) // Fixed mappedBy
    private List<Users> users;

    public UsersType() {
    }

    public UsersType(int usersTypeId, String userTypeName, List<Users> users) {
        this.usersTypeId = usersTypeId;
        this.userTypeName = userTypeName;
        this.users = users;
    }

    public int getUsersTypeId() {
        return usersTypeId;
    }

    public void setUsersTypeId(int usersTypeId) {
        this.usersTypeId = usersTypeId;
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
                "usersTypeId=" + usersTypeId +
                ", userTypeName='" + userTypeName + '\'' +
                '}';
    }
}
