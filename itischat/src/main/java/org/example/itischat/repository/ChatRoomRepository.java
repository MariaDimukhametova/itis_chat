package org.example.itischat.repository;

import org.example.itischat.model.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long> {
    ChatRoom updateName(ChatRoom chatRoom, String newName);

}
