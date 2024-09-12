package com.example.itsmbackend.payloads;


import com.example.itsmbackend.entity.User;
import com.example.itsmbackend.entity.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Long id;
    private String fullName;
    private String email;
    private String role;
    public UserDTO(User user) {
        this.id = user.getUserId();
        this.fullName = user.getFullName();
        this.email = user.getEmail();
        this.role = user.getRole().name();
    }

    public UserDTO(Object[] objects) {
        this.id = (Long) objects[0];
        this.email = (String) objects[1];
        this.fullName = (String) objects[2];
        this.role = ((Enum<?>) objects[3]).name();


    }
}
