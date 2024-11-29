package com.microservice.user.service.Userservice.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "user_information")
public class User {

    @Id
    @Column(name = "id")
    private String userId;

    @Column(name ="NAME",length = 20)
    private String name;

    @Column(name = "EMAIL_ADD")
    private String email;

    @Column(name = "ABOUT")
    private String about;

   @Transient
   private List<Rating> ratings;
}
