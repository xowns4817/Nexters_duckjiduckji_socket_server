package com.nexters.duckjiduckji.Controller;

import com.nexters.duckjiduckji.Dto.InOutDto;
import com.nexters.duckjiduckji.Dto.PolaroidContentDto;
import com.nexters.duckjiduckji.Dto.PolaroidPositionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class StompChatController {
    private final SimpMessagingTemplate template; //특정 Broker로 메세지를 전달

    // 클라에서 publish로 보내면 얘가 받음 -> publish/room/{roomId}

    // 방 in 처리
    @MessageMapping(value = "/room/join/{roomId}")
    public void roomJoin(@DestinationVariable("roomId") String roomId, InOutDto inDto){
        System.out.println("RoomId : " + roomId);
        System.out.println("message : " +  inDto.toString());
        template.convertAndSend("/subscribe/room/" + roomId, inDto);
    }

    // 방 out 처리
    @MessageMapping(value = "/room/leave/{roomId}")
    public void roomLeave(@DestinationVariable("roomId") String roomId, InOutDto outDto){
        System.out.println("RoomId : " + roomId);
        System.out.println("message : " +  outDto.toString());
        template.convertAndSend("/subscribe/room/" + roomId, outDto);
    }

    // 방에 데이터 publish (case 1) -> 이미지, 제목, 내용
    @MessageMapping(value = "/room/content/{roomId}")
    public void roomContent(@DestinationVariable("roomId") String roomId, PolaroidContentDto contentDto){
        System.out.println("RoomId : " + roomId);
        System.out.println("message : " +  contentDto.toString());
        contentDto.setMsgType("receiveContentMsg");
        template.convertAndSend("/subscribe/room/" + roomId, contentDto);
    }

    // 방에 데이터 publish (case 2) -> 좌표, 크기, rotation 값
    @MessageMapping(value = "/room/position/{roomId}")
    public void roomPosition(@DestinationVariable("roomId") String roomId, PolaroidPositionDto positionDto){
        System.out.println("RoomId : " + roomId);
        System.out.println("message : " +  positionDto.toString());
        positionDto.setMsgType("receivePositionMsg");
        template.convertAndSend("/subscribe/room/" + roomId, positionDto);
    }
}
