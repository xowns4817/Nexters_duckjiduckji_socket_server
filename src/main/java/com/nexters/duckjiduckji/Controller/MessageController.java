package com.nexters.duckjiduckji.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nexters.duckjiduckji.Const.MsgType;
import com.nexters.duckjiduckji.Dto.*;
import com.nexters.duckjiduckji.Service.MessageService;
import com.nexters.duckjiduckji.Util.ApiHelper;
import com.nexters.duckjiduckji.Util.JsonUtil;
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
    private final MessageService messageService;
    private final JsonUtil jsonUtil;

    // 방 in 처리
    @MessageMapping(value = "/room/{roomId}")
    public void roomJoin(@DestinationVariable("roomId") String roomId, Message message) throws JsonProcessingException {

        System.out.println(jsonUtil.printJson(message));
        MsgType msgType = message.getMsgType();
        Message forwardMessage = message;

        if(msgType == MsgType.CREATE) forwardMessage = messageService.MessageCreateService(message);
        else if(msgType == MsgType.UPDATE) forwardMessage = messageService.MessageUpdateService(message);
        else if(msgType == MsgType.DELETE) forwardMessage = messageService.MessageDeleteService(message);
        else if(msgType == MsgType.JOIN) forwardMessage = messageService.MessageInService(message);
        else if(msgType == MsgType.LEAVE) forwardMessage = messageService.MessageOutService(message);

        template.convertAndSend("/subscribe/room/" + roomId, forwardMessage);
    }
}
