package org.example.itischat.mapper;

import org.example.itischat.dto.ChatRoomDto;
import org.example.itischat.model.ChatRoom;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ChatRoomMapper {
    ChatRoomDto getChatRoomDto(ChatRoom chatRoom);
    ChatRoom getChatRoom(ChatRoomDto chatRoomDto);
}
