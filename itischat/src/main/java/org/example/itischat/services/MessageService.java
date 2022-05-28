package org.example.itischat.services;

import org.example.itischat.dto.ChatRoomDto;
import org.example.itischat.dto.MessageDto;

import java.util.List;

public interface MessageService {
    List<MessageDto> getAllMessagesFromChat(ChatRoomDto chatRoomDto);
    MessageDto writeMessage(MessageDto messageDto);
    MessageDto editMessage(MessageDto messageDto, String newText);
}
