package com.joborbit.joborbit.services;

import com.joborbit.joborbit.entity.JobSeekerProfile;
import com.joborbit.joborbit.entity.RecruiterProfile;
import com.joborbit.joborbit.entity.Users;
import com.joborbit.joborbit.repository.JobSeekerProfileRepository;
import com.joborbit.joborbit.repository.RecruiterProfileRepository;
import com.joborbit.joborbit.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId;

@Service
public class UsersService {

    private final UserRepository userRepository;
    private final JobSeekerProfileRepository jobSeekerProfileRepository;
    private final RecruiterProfileRepository recruiterProfileRepository;

    public UsersService(UserRepository userRepository,
                        JobSeekerProfileRepository jobSeekerProfileRepository,
                        RecruiterProfileRepository recruiterProfileRepository) {
        this.userRepository = userRepository;
        this.jobSeekerProfileRepository = jobSeekerProfileRepository;
        this.recruiterProfileRepository = recruiterProfileRepository;
    }

    public Users addNew(Users users) {
        users.setActive(true);
        users.setRegistrationDate(convertLocalDateToDate(LocalDate.now()));  // Convert LocalDate to Date
        Users savedUser = userRepository.save(users);

        int userTypeId = users.getUserType().getUserTypeId();
        if (userTypeId == 1) {
            recruiterProfileRepository.save(new RecruiterProfile(savedUser));
        } else {
            jobSeekerProfileRepository.save(new JobSeekerProfile(savedUser));
        }
        return savedUser;
    }

    // Helper method to convert LocalDate to Date
    private Date convertLocalDateToDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public boolean emailExists(String email) {
        return userRepository.findByEmail(email).isPresent();




    }
}




