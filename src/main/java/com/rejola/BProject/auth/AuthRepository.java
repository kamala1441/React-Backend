package com.rejola.BProject.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rejola.BProject.master.user.Users;

import java.util.Optional;
@Repository
public interface AuthRepository extends JpaRepository<Users, Integer> {

  Optional<Users> findByEmpId(String username);
  Optional<Users> findByEmail(String email);


}
