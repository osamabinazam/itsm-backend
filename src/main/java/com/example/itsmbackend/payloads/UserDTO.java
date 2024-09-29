package com.example.itsmbackend.payloads;


import com.example.itsmbackend.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The UserDTO class represents a data transfer object for a User entity.
 * It is used to transfer User data between the frontend and backend.
 * The class is annotated with @Getter, @Setter, @AllArgsConstructor, and @NoArgsConstructor
 * to automatically generate the getters, setters, constructors, and no-args constructor.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Long id;
    private String fullName;
    private String email;
    private String role;

    /**
     * Constructor for UserDTO
     * @param user User object
     */
    public UserDTO(User user) {
        this.id = user.getUserId();
        this.fullName = user.getFullName();
        this.email = user.getEmail();
        this.role = user.getRole().name();

    }

    /**
     * Constructor for UserDTO
     * @param objects Object array containing user data
     */
    public UserDTO(Object[] objects) {
        this.id = (Long) objects[0];
        this.email = (String) objects[1];
        this.fullName = (String) objects[2];
        this.role = ((Enum<?>) objects[3]).name();


    }
}
