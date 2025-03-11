package com.joborbit.joborbit.services;

import com.joborbit.joborbit.entity.Users;
import com.joborbit.joborbit.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

    private final UserRepository userRepository;

    public UsersService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Users addNew(Users users) {
        users.setActive(true);
        users.setRegistrationDate(new Date(System.currentTimeMillis()));
        return userRepository.save(users);
    }

    public boolean emailExists(String email) {
        List<Users> usersList = userRepository.findByEmail(email);
        return !usersList.isEmpty();  // Ensures duplicate emails are handled
    }
}
