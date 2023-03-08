package com.rejola.BProject.master.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<Users, UUID> {
    Optional<Users> findByEmpId(String empId);
    Optional<Users> findByEmail(String email);

    List<Users> findByEmpIdOrEmail(String empId, String email);

}
