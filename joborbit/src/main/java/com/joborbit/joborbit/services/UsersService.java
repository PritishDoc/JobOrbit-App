package com.joborbit.joborbit.services;

import com.joborbit.joborbit.entity.JobSeekerProfile;
import com.joborbit.joborbit.entity.RecrutorProfile;
import com.joborbit.joborbit.entity.Users;
import com.joborbit.joborbit.repository.JobSeekerProfileRepository;
import com.joborbit.joborbit.repository.RecrutorProfileRepository;
import com.joborbit.joborbit.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UsersService {

    private final UserRepository userRepository;
    private final JobSeekerProfileRepository jobSeekerProfileRepository;
    private final RecrutorProfileRepository recrutorProfileRepository;

    public UsersService(UserRepository userRepository,JobSeekerProfileRepository,jobSeekerProfileRepository
                        ,RecrutorProfileRepository,recrutorProfileRepository) {
        this.userRepository = userRepository;
        this.jobSeekerProfileRepository=jobSeekerProfileRepository;
        this.recrutorProfileRepository=recrutorProfileRepository;
    }

    public Users addNew(Users users) {
        users.setActive(true);
        users.setRegistrationDate(new Date(System.currentTimeMillis()));
        Users savedUser=userRepository.save(users);
        int userTypeId= users.getUserType().getUserTypeId();
        if(userTypeId == 1){
            recrutorProfileRepository.save(new RecrutorProfile(users));
        }
        else {
            jobSeekerProfileRepository.save(new JobSeekerProfile(users));
        }
        return savedUser;
    }

    public boolean emailExists(String email) {
        List<Users> usersList = userRepository.findByEmail(email);
        return !usersList.isEmpty();  // Ensures duplicate emails are handled
    }
}
