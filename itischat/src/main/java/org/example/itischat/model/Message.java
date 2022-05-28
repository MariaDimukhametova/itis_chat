package org.example.itischat.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Message extends AbstractEntity{
    @ManyToOne
    private User author;
    private String text;
    @ManyToOne
    private ChatRoom chatRoom;
}
