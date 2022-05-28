package org.example.itischat.services.impl;


import lombok.Builder;
import org.example.itischat.dto.ChatRoomDto;
import org.example.itischat.dto.UserDto;
import org.example.itischat.repository.ChatRoomRepository;
import org.example.itischat.services.ChatRoomService;
import org.springframework.stereotype.Service;

@Service
@Builder
public class ChatRoomServiceImpl implements ChatRoomService {
    private final ChatRoomRepository chatRoomRepository;

    @Override
    public ChatRoomDto updateName(ChatRoomDto chatRoomDto, String newName) {
        return null;
    }

    @Override
    public UserDto addUser(ChatRoomDto chatRoomDto, UserDto userDto) {
        return null;
    }

    @Override
    public UserDto deleteUser(ChatRoomDto chatRoomDto, UserDto userDto) {
        return null;
    }
}
