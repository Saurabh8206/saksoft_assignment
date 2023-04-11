package com.saksoft.service;

import com.saksoft.model.UserEntity;

import java.util.List;

public interface UserService {

    List<UserEntity> getAllUsers();

    UserEntity createUser(UserEntity post);

    UserEntity editUser(long userId, UserEntity post);

    void deleteUser(long userId);

    UserEntity getUserByuserId(long userId);

    UserEntity getByEmail(String email);
}
