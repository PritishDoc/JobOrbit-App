package com.joborbit.JobOrbit.Entity;

import jakarta.persistence.*;

import java.lang.annotation.Target;
import java.util.List;

public class UsersType {
    @Entity
    @Table(name = "users_type")
    public class UserType{
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int usersTypeId;

        private String userTypeName;

        @OneToMany(targetEntity = Users.class,mappedBy = "UserTypeId",cascade = CascadeType.ALL)
        private List<Users> users;

        public UserType() {
        }

        public UserType(int usersTypeId, String userTypeName, List<Users> users) {
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
            return "UserType{" +
                    "userTypeName='" + userTypeName + '\'' +
                    ", usersTypeId=" + usersTypeId +
                    '}';
        }
    }
}
