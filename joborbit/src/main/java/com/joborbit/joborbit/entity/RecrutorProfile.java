package com.joborbit.joborbit.entity;

import jakarta.persistence.*;

public class RecrutorProfile {




    @Entity
    @Table(name="recruiter_profile")
    public class RecruiterProfile{
        @Id
        private int userAccountId;
        @ManyToOne
        @JoinColumn(name="user_account_id")
        @MapsId
        private Users userId;

        private String firstName;
        private String lastName;
        private String city;
        private String state;
        private String country;
        private String company;
        @Column(nullable = true,length = 64)
        private String profilePhoto;



        public RecruiterProfile() {

        }


        public int getUserAccountId() {
            return userAccountId;
        }

        public void setUserAccountId(int userAccountId) {
            this.userAccountId = userAccountId;
        }

        public Users getUsersId() {
            return userId;
        }

        public void setUsersId(Users usersId) {
            this.userId = usersId;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getCompany() {
            return company;
        }

        public void setCompany(String company) {
            this.company = company;
        }

        public String getProfilePhoto() {
            return profilePhoto;
        }

        public void setProfilePhoto(String profilePhoto) {
            this.profilePhoto = profilePhoto;
        }

        @Override
        public String toString() {
            return "RecruiterProfile{" +
                    "userAccountId=" + userAccountId +
                    ", usersId=" + userId +
                    ", firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", city='" + city + '\'' +
                    ", state='" + state + '\'' +
                    ", country='" + country + '\'' +
                    ", company='" + company + '\'' +
                    ", profilePhoto='" + profilePhoto + '\'' +
                    '}';
        }
    }

    public RecrutorProfile(Users users) {
        this.userId=users;
    }

}
