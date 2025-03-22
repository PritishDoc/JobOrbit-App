package com.joborbit.joborbit.services;

import com.joborbit.joborbit.entity.JobSeekerProfile;
import com.joborbit.joborbit.entity.RecruiterProfile;
import com.joborbit.joborbit.entity.Users;
import com.joborbit.joborbit.repository.JobSeekerProfileRepository;
import com.joborbit.joborbit.repository.RecruiterProfileRepository;
import com.joborbit.joborbit.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Optional;

@Service
public class UsersService {

    private final UserRepository userRepository;
    private final JobSeekerProfileRepository jobSeekerProfileRepository;
    private final RecruiterProfileRepository recruiterProfileRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UsersService(UserRepository userRepository,
                        JobSeekerProfileRepository jobSeekerProfileRepository,
                        RecruiterProfileRepository recruiterProfileRepository,
                        BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.jobSeekerProfileRepository = jobSeekerProfileRepository;
        this.recruiterProfileRepository = recruiterProfileRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Users addNew(Users users) {
        users.setActive(true);
        users.setRegistrationDate(convertLocalDateToDate(LocalDate.now()));
        users.setPassword(passwordEncoder.encode(users.getPassword()));
        Users savedUser = userRepository.save(users);

        if (users.getUserTypeId() != null) {
            int userTypeId = users.getUserTypeId().getUserTypeId();
            if (userTypeId == 1) {
                recruiterProfileRepository.save(new RecruiterProfile(savedUser));
            } else {
                jobSeekerProfileRepository.save(new JobSeekerProfile(savedUser));
            }
        }
        return savedUser;
    }

    private Date convertLocalDateToDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public boolean emailExists(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    public Optional<Users> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
