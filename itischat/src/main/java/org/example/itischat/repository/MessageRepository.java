package org.example.itischat.repository;

import org.example.itischat.model.ChatRoom;
import org.example.itischat.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findAllByChatRoom(ChatRoom chatRoom);
    Message updateMessage(Message message, String newText);
}
