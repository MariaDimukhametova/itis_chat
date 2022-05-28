package org.example.itischat.mapper;

import org.example.itischat.dto.MessageDto;
import org.example.itischat.model.Message;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MessageMapper {
    MessageDto getMessageDto(Message message);
    Message getMessage(MessageDto messageDto);
}
