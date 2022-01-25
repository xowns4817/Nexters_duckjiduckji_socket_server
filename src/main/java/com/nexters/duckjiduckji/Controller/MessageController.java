package com.nexters.duckjiduckji.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nexters.duckjiduckji.Dto.MessageDto;
import com.nexters.duckjiduckji.Dto.PolaroidContentCreateDto;
import com.nexters.duckjiduckji.Util.ApiHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

// 클라에서 publish로 보내면 얘가 받음 -> publish/room/{roomId}
@Controller
@RequiredArgsConstructor
public class MessageController {
    private final SimpMessagingTemplate template; //특정 Broker로 메세지를 전달
    private final ApiHelper apiHelper;

    // 방 in 처리
    @MessageMapping(value = "/room/{roomId}")
    public void roomJoin(@DestinationVariable("roomId") String roomId, MessageDto messageDto) throws JsonProcessingException {
        System.out.println("RoomId : " + roomId);
        System.out.println("message : " +  messageDto.toString());

        // 폴라로이드 생성 요청 일때는 만들어진 폴라로이드 ID 추가해서 sub 채널로 보내야됨
        if(messageDto instanceof PolaroidContentCreateDto) {
            ((PolaroidContentCreateDto) messageDto).setContentId("asdlksldk"); // api 서버에서 폴라로이드 만들고 리턴해준 id 세팅
        }
        String json = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(messageDto);
        System.out.println(json);

        template.convertAndSend("/subscribe/room/" + roomId, messageDto);
    }
}
