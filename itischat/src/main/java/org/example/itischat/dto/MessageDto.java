package org.example.itischat.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MessageDto {
    private UserDto author;
    private String text;
    private ChatRoomDto chatRoom;
}
