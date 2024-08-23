package com.contest.grass.service;

import com.contest.grass.entity.User;
import com.contest.grass.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 1. 로그인
    public User login(String email, String password) {
        Optional<User> user = userRepository.findByEmailAndPassword(email, password);
        return user.orElseThrow(() -> new RuntimeException("Invalid email or password"));
    }

    // 2. 회원가입
    public User register(String email, String name, String password, String phoneNumber) {
        User user = new User();
        user.setEmail(email);
        user.setName(name);
        user.setPassword(password);
        user.setPhoneNumber(phoneNumber);
        user.setNickname(UUID.randomUUID().toString().substring(0, 8)); // 임시 닉네임 생성
        user.setSprouts(0); // 새싹 초기값
        return userRepository.save(user);
    }

    // 3. 아이디 찾기 (전화번호로 이메일 찾기)
    public String findEmailByPhoneNumber(String phoneNumber) {
        Optional<User> user = userRepository.findByPhoneNumber(phoneNumber);
        return user.map(User::getEmail).orElseThrow(() -> new RuntimeException("User not found"));
    }

    // 4. 비밀번호 찾기 (임시 비밀번호 발송)
    public String sendTemporaryPassword(String phoneNumber) {
        User user = userRepository.findByPhoneNumber(phoneNumber)
                .orElseThrow(() -> new RuntimeException("User not found"));
        String tempPassword = UUID.randomUUID().toString().substring(0, 8);
        user.setPassword(tempPassword);
        userRepository.save(user);
        // 실제로는 이 임시 비밀번호를 사용자에게 SMS나 이메일로 보내야 함
        return tempPassword;
    }

    // 5. 비밀번호 재설정
    public User resetPassword(String email, String newPassword) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setPassword(newPassword);
        return userRepository.save(user);
    }

    // 6. 마이페이지 조회
    public User getUserProfile(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        return user.orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
    }
}