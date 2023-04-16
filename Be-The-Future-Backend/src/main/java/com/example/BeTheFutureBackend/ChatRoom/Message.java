package com.example.BeTheFutureBackend.ChatRoom;


import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Message {
    private String sender;
    private String receiver;
    private String content;
    private String timestamp;

    @Enumerated(EnumType.STRING)
    private Status status;
}
