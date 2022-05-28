package org.example.itischat.controllers;

import lombok.RequiredArgsConstructor;
import org.example.itischat.dto.ChatRoomDto;
import org.example.itischat.dto.MessageDto;
import org.example.itischat.services.MessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("messages")
@RequiredArgsConstructor
public class MessageController {
    private final MessageService messageService;

    @PostMapping
    ResponseEntity<MessageDto> writeMessage(@Valid @RequestBody MessageDto messageDto) {
        return ResponseEntity.ok(messageService.writeMessage(messageDto));
    }

    @PostMapping
    ResponseEntity<MessageDto> editMessage(@Valid @RequestBody MessageDto messageDto, String newText) {
        return ResponseEntity.ok(messageService.editMessage(messageDto, newText));
    }

    @GetMapping
    List<MessageDto> getAllMessagesFromChat(@Valid @RequestBody ChatRoomDto chatRoomDto){
        return messageService.getAllMessagesFromChat(chatRoomDto);
    }

}
