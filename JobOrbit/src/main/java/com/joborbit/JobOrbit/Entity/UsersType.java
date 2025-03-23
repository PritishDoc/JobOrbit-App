package com.joborbit.JobOrbit.Entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "users_type") // Changed to match DB table
public class UsersType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_type_id") // Changed column name
    private int userTypeId;

    @Column(name = "user_type_name", nullable = false, unique = true) // Added column name explicitly
    private String userTypeName;

    @OneToMany(targetEntity = Users.class, mappedBy = "userType", cascade = CascadeType.ALL)
    private List<Users> users;

    public UsersType() {}

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
