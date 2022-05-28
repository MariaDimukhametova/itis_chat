package org.example.itischat.mapper;

import org.example.itischat.dto.UserDto;
import org.example.itischat.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto getUserDto(User user);
    User getUser(UserDto userDto);
}
