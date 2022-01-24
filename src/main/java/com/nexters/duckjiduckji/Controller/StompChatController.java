package com.nexters.duckjiduckji.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nexters.duckjiduckji.Dto.MessageDto;
import com.nexters.duckjiduckji.Util.ApiHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class StompChatController {
    private final SimpMessagingTemplate template; //특정 Broker로 메세지를 전달
    private final ApiHelper apiHelper;

    // 클라에서 publish로 보내면 얘가 받음 -> publish/room/{roomId}

    // 방 in 처리
    @MessageMapping(value = "/room/{roomId}")
    public void roomJoin(@DestinationVariable("roomId") String roomId, MessageDto messageDto) throws JsonProcessingException {
        System.out.println("RoomId : " + roomId);
        System.out.println("message : " +  messageDto.toString());
        String json = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(messageDto);
        System.out.println(json);

        // 폴라로이드 생성일때는 만들어진 ID 추가해서 sub채널로 보내야됨
        template.convertAndSend("/subscribe/room/" + roomId, messageDto);
    }
}
