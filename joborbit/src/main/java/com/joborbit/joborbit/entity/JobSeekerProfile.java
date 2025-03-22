package com.joborbit.joborbit.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "job_seeker_profile")
public class JobSeekerProfile {

    @Id
    private int userAccountId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_account_id")
    @MapsId
    private Users users;

    private String firstName;
    private String lastName;
    private String city;
    private String state;
    private String country;
    private String workAuthorization;
    private String employmentType;
    private String resume;

    @Column(nullable = true, length = 64)
    private String profilePhoto;

    public JobSeekerProfile() {}

    public JobSeekerProfile(Users users) {
        this.users = users;
    }

    // Getters and Setters
}
