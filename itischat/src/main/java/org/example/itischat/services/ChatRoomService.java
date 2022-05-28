package org.example.itischat.services;

import org.example.itischat.dto.ChatRoomDto;
import org.example.itischat.dto.UserDto;

public interface ChatRoomService {
    ChatRoomDto updateName(ChatRoomDto chatRoomDto, String newName);
    UserDto addUser(ChatRoomDto chatRoomDto, UserDto userDto);
    UserDto deleteUser(ChatRoomDto chatRoomDto, UserDto userDto);

}
