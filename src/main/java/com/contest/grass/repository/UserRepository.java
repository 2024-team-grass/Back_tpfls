package com.contest.grass.repository;

import com.contest.grass.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email, String password);
    Optional<User> findByPhoneNumber(String phoneNumber);

    Optional<User> findByKakaoId(String id);

    Optional<User> findByGoogleId(String sub);

    boolean existsByEmail(String email);
}