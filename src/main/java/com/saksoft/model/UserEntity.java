package com.saksoft.model;


import jakarta.persistence.*;
import lombok.*;


/**
 * @author Saurabh Kohade
 *
 * User Entity class
 *
 */
@Entity
@Table(name = "tbl_saksoft_users")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USERID", nullable = false)
    private long userId;

    @Column(name = "FIRSTNAME")
    private String firstName;

    @Column(name = "LASTNAME")
    private String lastName;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "AGE")
    private String age;

}
