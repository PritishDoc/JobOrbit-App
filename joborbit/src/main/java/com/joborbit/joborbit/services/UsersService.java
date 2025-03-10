package com.joborbit.joborbit.services;

import com.joborbit.joborbit.entity.Users;
import com.joborbit.joborbit.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
public class UsersService {

    private final UserRepository userRepository;  // Fixed repository name

    public UsersService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Users addNew(Users users) {
        users.setActive(true);
        users.setRegistrationDate(new Date(System.currentTimeMillis())); // Added import for Date
        return userRepository.save(users);  // Fixed repository usage
    }
}
