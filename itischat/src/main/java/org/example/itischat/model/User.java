package org.example.itischat.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User extends AbstractEntity{
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
