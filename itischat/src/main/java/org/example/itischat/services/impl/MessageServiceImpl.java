package org.example.itischat.services.impl;

import lombok.RequiredArgsConstructor;
import org.example.itischat.dto.ChatRoomDto;
import org.example.itischat.dto.MessageDto;
import org.example.itischat.mapper.ChatRoomMapper;
import org.example.itischat.mapper.MessageMapper;
import org.example.itischat.model.Message;
import org.example.itischat.repository.MessageRepository;
import org.example.itischat.services.MessageService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {
    private final MessageRepository messageRepository;
    private final MessageMapper messageMapper;
    private final ChatRoomMapper chatRoomMapper;

    @Override
    public List<MessageDto> getAllMessagesFromChat(ChatRoomDto chatRoomDto) {
        return messageRepository.findAllByChatRoom(chatRoomMapper.getChatRoom(chatRoomDto))
                .stream().map(messageMapper::getMessageDto)
                .collect(Collectors.toList());
    }

    @Override
    public MessageDto writeMessage(MessageDto messageDto) {
        Message message = messageMapper.getMessage(messageDto);
        messageRepository.save(message);
        return messageMapper.getMessageDto(message);
    }

    @Override
    public MessageDto editMessage(MessageDto messageDto, String newText) {
        Message message = messageMapper.getMessage(messageDto);
        Message updatedMessage = messageRepository.updateMessage(message, newText);
        return messageMapper.getMessageDto(updatedMessage);
    }

}
