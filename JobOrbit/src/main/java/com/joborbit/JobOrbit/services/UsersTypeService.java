package com.joborbit.JobOrbit.services;

import ch.qos.logback.core.model.Model;
import com.joborbit.JobOrbit.Entity.UsersType;
import com.joborbit.JobOrbit.repository.UsersTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersTypeService {
    private final UsersTypeRepository usersTypeRepository;


    @Autowired
    public UsersTypeService(UsersTypeRepository usersTypeRepository) {
        this.usersTypeRepository = usersTypeRepository;
    }
    public List<UsersType> getAll(){
        return  usersTypeRepository.findAll();
    }

}
