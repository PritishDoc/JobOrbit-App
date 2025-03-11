package com.joborbit.joborbit.services;

import com.joborbit.joborbit.entity.JobSeekerProfile;
import com.joborbit.joborbit.entity.RecruiterProfile;
import com.joborbit.joborbit.entity.Users;
import com.joborbit.joborbit.repository.JobSeekerProfileRepository;
import com.joborbit.joborbit.repository.RecruiterProfileRepository;
import com.joborbit.joborbit.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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
        users.setRegistrationDate(new Date());
        Users savedUser = userRepository.save(users);

        int userTypeId = users.getUserType().getUserTypeId();
        if (userTypeId == 1) {
            recruiterProfileRepository.save(new RecruiterProfile(savedUser));
        } else {
            jobSeekerProfileRepository.save(new JobSeekerProfile(savedUser));
        }
        return savedUser;
    }

    public boolean emailExists(String email) {
        List<Users> usersList = userRepository.findByEmail(email);
        return !usersList.isEmpty(); // Ensures duplicate emails are handled
    }
}
