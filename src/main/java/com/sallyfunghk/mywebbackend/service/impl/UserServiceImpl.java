package com.sallyfunghk.mywebbackend.service.impl;

import com.sallyfunghk.mywebbackend.entity.User;
import com.sallyfunghk.mywebbackend.repository.UserRepository;
import com.sallyfunghk.mywebbackend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long userId) {

        Optional<User> optionalUser = userRepository.findById(userId);
        return optionalUser.get();
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user) {
        User existingUser = userRepository.findById(user.getId()).get();

        existingUser.setName(user.getName());
        existingUser.setEnabled(user.isEnabled());
        existingUser.setRole(user.getRole());

        User updatedUser = userRepository.save(existingUser);
        return updatedUser;
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public User changePassword(User user) {
        User existingUser = userRepository.findById(user.getId()).get();

        if (user.getOldPassword() != existingUser.getPassword()) {
            // TODO: Throw exception
        }
        existingUser.setPassword(user.getPassword());

        User updatedUser = userRepository.save(existingUser);
        return updatedUser;
    }
}