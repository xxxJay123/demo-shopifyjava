package com.xxxjay123.app.demoshopifyjava.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xxxjay123.app.demoshopifyjava.entity.User;
import com.xxxjay123.app.demoshopifyjava.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
  @Autowired
  private UserRepository userRepository;

  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  public Optional<User> getUserById(Long userId) {
    return userRepository.findById(userId);
  }

  public User createUser(User user) {
    return userRepository.save(user);
  }

  public User updateUser(Long userId, User updatedUser) {
    if (userRepository.existsById(userId)) {
      updatedUser.setUserId(userId);
      return userRepository.save(updatedUser);
    }
    return null; // Handle not found case
  }

  public void deleteUser(Long userId) {
    userRepository.deleteById(userId);
  }
}
