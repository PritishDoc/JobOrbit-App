package com.joborbit.joborbit.services;

import com.joborbit.joborbit.entity.UsersType;
import com.joborbit.joborbit.repository.UserTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserTypeService {
    private final UserTypeRepository userTypeRepository;

    public UserTypeService(UserTypeRepository userTypeRepository) {
        this.userTypeRepository = userTypeRepository;
    }
    public List<UsersType> getAll(){
        return userTypeRepository.findAll();
    }
}
