package com.usermanager.users;

import javax.validation.constraints.NotNull;
import com.usermanager.users.enuns.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder(builderClassName = "Builder")
@Entity(name = "user")
@EqualsAndHashCode(of = {"id"})
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_generator")
    @SequenceGenerator(name = "user_generator", sequenceName = "user_sequence", allocationSize = 1)
    private Long id;

    @NotBlank(message = "firstName cannot be blank")
    @NotNull(message = "firstName is mandatory")
    @Size(min = 3, max = 64, message = "firstName must be less than 64 characters")
    private String firstName;

    @NotBlank(message = "lastName cannot be blank")
    @NotNull(message = "lastName is mandatory")
    @Size(min = 3, max = 64, message = "lastName must be less than 64 characters")
    private String lastName;

    @NotNull(message = "email is mandatory")
    @Size(max = 64, message = "email must be less than 64 characters")
    @Email(message = "email should be valid")
    @Column(unique = true)
    private String email;

    @NotNull(message = "password is mandatory")
    private String password;

    /*@NotNull(message = "type is mandatory")
    private UserType type;*/

    private String profilePicture;

    @NotNull(message = "creationDate is mandatory")
    private LocalDateTime creationDate;

    private LocalDateTime lastLoginDate;
}
