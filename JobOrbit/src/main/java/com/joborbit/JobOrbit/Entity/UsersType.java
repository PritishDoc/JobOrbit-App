package com.joborbit.JobOrbit.Entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "users_type")
public class UsersType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "users_type_id")
    private int userTypeId;

    @Column(name = "user_type_name", nullable = false, unique = true)
    private String userTypeName;

    @OneToMany(targetEntity = Users.class, mappedBy = "userType", cascade = CascadeType.ALL)
    private List<Users> users;

    public UsersType() {}

    public UsersType(int usersTypeId, String userTypeName, List<Users> users) {
        this.userTypeId = usersTypeId;
        this.userTypeName = userTypeName;
        this.users = users;
    }

    // Getters and Setters

    @Override
    public String toString() {
        return "UsersType{" +
                "usersTypeId=" + userTypeId +
                ", userTypeName='" + userTypeName + '\'' +
                '}';
    }
}
