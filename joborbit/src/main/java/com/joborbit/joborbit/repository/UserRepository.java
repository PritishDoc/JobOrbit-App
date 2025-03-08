package com.joborbit.joborbit.repository;

import com.joborbit.joborbit.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users,Integer> {
}
