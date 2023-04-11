package com.saksoft.controller;

import com.saksoft.model.UserEntity;
import com.saksoft.requestVO.UserVO;
import com.saksoft.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Saurabh Kohade
 *
 *         Controller class for handlers. All opertaions for Users :
 *         CREATE,EDIT,DELETE,
 *
 */
@RestController
@RequestMapping(path = "/users")
public class UserController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserService service;

    /**
     * @return List of users in database
     */
    @GetMapping(path = "/users")
    public List<UserVO> getUsers() {
        try {
            return service.getAllUsers().stream().map(user -> modelMapper.map(user, UserVO.class))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            System.out.println("EXCEPTION IN CLASS" + this.getClass().getName() + "--->" + e);
            return List.of();
        }

    }

    /**
     * @return List of users in database
     */
    @GetMapping(path = "/getByEmail/{email}")
    public UserEntity getByEmail(@PathVariable String email) {
        try {
            return service.getByEmail(email);
        } catch (Exception e) {
            System.out.println("EXCEPTION IN CLASS" + this.getClass().getName() + "--->" + e);
            return null;
        }

    }

    /**
     *
     * @param entity
     * @return
     */
    @PostMapping(path = "/create")
    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity entity) {

        try {
            service.createUser(entity);
            return new ResponseEntity<>(entity, HttpStatus.CREATED);

        } catch (Exception e) {
            System.out.println("EXCEPTION IN CLASS" + this.getClass().getName() + "--->" + e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }

    }

    /**
     * @param userId
     * @param entity
     *
     * Update/Edit the users details by fetching its record by userId(PK)
     *
     */
    @PutMapping(path = "/edit/{userId}")
    public ResponseEntity<UserEntity> editUser(@PathVariable long userId, @RequestBody UserEntity entity) {

        try {
            service.editUser(userId, entity);
            return new ResponseEntity<>(entity, HttpStatus.OK);

        } catch (Exception e) {
            System.out.println("EXCEPTION IN CLASS" + this.getClass().getName() + "--->" + e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }

    }

    /**
     * @param userId
     *
     * Deletes the record of user of user by particular userId
     */
    @DeleteMapping(path = "/delete/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable long userId) {

        try {
            service.deleteUser(userId);
            return  ResponseEntity.status(200).body("User Deleted");

        } catch (Exception e) {
            System.out.println("EXCEPTION IN CLASS :: " + this.getClass().getName() + "--->" + e);
            return ResponseEntity.status(400).body("EXCEPTION IN CLASS :: " + this.getClass().getName() + "--->" + e);

        }

    }

}
