package org.example.itischat.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "users")
public class User extends AbstractEntity{
    private String firstName;
    private String lastName;
    private String email;
    private String hashPassword;
    @Enumerated(value = EnumType.STRING)
    private State state;
    @Enumerated(value = EnumType.STRING)
    private Role role;


    public boolean isActive() {
        return this.state == State.ACTIVE;
    }
}
