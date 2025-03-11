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
        private Users usersId;

        private String firstName;
        private String lastName;
        private String city;
        private String state;
        private String country;
        private String company;
        @Column(nullable = true,length = 64)
        private String profilePhoto;


    }
    

}
