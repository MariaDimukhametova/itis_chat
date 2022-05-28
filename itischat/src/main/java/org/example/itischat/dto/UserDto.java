package org.example.itischat.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    @NotBlank(message = "Field must not be empty")
    private String firstName;
    @NotBlank(message = "Field must not be empty")
    private String lastName;
    @NotBlank(message = "Field must not be empty")
    private String email;
    @NotBlank(message = "Field must not be empty")
    private String password;
}
