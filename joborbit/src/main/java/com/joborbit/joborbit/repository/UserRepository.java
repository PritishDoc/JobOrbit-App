package com.joborbit.joborbit.repository;

import com.joborbit.joborbit.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UserRepository extends JpaRepository<Users, Integer> {
    List<Users> findByEmail(String email);  // Returns list to handle multiple results
}
