package com.nexters.duckjiduckji.Dto;

import lombok.*;
import org.springframework.web.socket.WebSocketSession;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ChatRoomDto {
    private String roomId;
    private String roomName;

    public static ChatRoomDto create(String name){
        ChatRoomDto room = new ChatRoomDto();

        room.roomId = UUID.randomUUID().toString();
        room.roomName = name;
        return room;
    }
}
