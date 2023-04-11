package com.saksoft.impl;


import com.saksoft.model.UserEntity;
import com.saksoft.exception.ResourceNotFoundException;
import com.saksoft.repository.UserRepository;
import com.saksoft.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Saurabh Kohade
 *
 * The service implementation class for the operations.
 *
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public List<UserEntity> getAllUsers() {
        try {
            return userRepo.findAll();
        } catch (Exception e) {
            System.out.println("EXCEPTION IN CLASS" + this.getClass().getName() + "--->" + e);
            return List.of();
        }
    }

    @Override
    public UserEntity createUser(UserEntity user) {
        try {
            if (user != null) {
                return userRepo.save(user);
            }
        } catch (Exception e) {
            System.out.println("EXCEPTION IN CLASS" + this.getClass().getName() + "--->" + e);
        }
        return user;

    }

    @Override
    public UserEntity editUser(long userId, UserEntity user) {
        UserEntity entity = null;
        if (user != null) {

            entity = getUserByuserId(userId);

            if (entity != null) {
                entity = userRepo.save(user);
            }

        } else {
            throw new IllegalArgumentException("Request Entity is Null");
        }
        return entity;

    }

    @Override
    public void deleteUser(long userId) {

        try {
            if (userRepo.existsById(userId)) {
                userRepo.deleteById(userId);
            } else {
                throw new ResourceNotFoundException("Could not delete the record with Id " + userId + ". Id was not found.");
            }
        } catch (Exception e) {
            System.out.println("EXCEPTION IN CLASS" + this.getClass().getName() + "--->" + e);
        }

    }

    @Override
    public UserEntity getUserByuserId(long userId) {

        try {
            Optional<UserEntity> result = userRepo.findById(userId);

            if (result.isPresent()) {
                return result.get();
            } else {
                throw new ResourceNotFoundException("Could not find a record with Id " + userId);
            }
        } catch (Exception e) {
            System.out.println("EXCEPTION IN CLASS" + this.getClass().getName() + "--->" + e);
            return null;
        }

    }

    @Override
    public UserEntity getByEmail(String email) {
        try {
            Optional<UserEntity> result = userRepo.findByEmail(email);

            if (result.isPresent()) {
                return result.get();
            } else {
                throw new ResourceNotFoundException("Could not find a record with email " + email);
            }
        } catch (Exception e) {
            System.out.println("EXCEPTION IN CLASS" + this.getClass().getName() + "--->" + e);
            return null;
        }
    }


}
