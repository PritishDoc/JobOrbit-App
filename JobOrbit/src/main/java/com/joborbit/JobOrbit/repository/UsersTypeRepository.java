package com.joborbit.JobOrbit.repository;

import com.joborbit.JobOrbit.Entity.Users;
import com.joborbit.JobOrbit.Entity.UsersType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersTypeRepository extends JpaRepository<UsersType,Integer> {

}
