package com.nexters.duckjiduckji.Service;

import com.nexters.duckjiduckji.Const.MsgType;
import com.nexters.duckjiduckji.Dto.*;
import com.nexters.duckjiduckji.Util.ApiHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final RestTemplate restTemplate;
    private final ApiHelper apiHelper;

    // return messageDto instance
    public MsgType getMsgType(Message messageDto) {
        if(messageDto instanceof ContentCreateDto) return MsgType.CREATE;
        else if(messageDto instanceof ContentUpdateDto) return MsgType.UPDATE;
        else if(messageDto instanceof ContentDeleteDto) return MsgType.DELETE;
        else if(messageDto instanceof InMessage) return MsgType.JOIN;
        else if(messageDto instanceof OutMessage) return MsgType.LEAVE;
        else return null;
    };

    public Message callApiServer(Message messageDto) {

        MsgType msgType = getMsgType(messageDto);
        // 폴라로이드 생성 요청 일때는 만들어진 폴라로이드 ID 추가해서 sub 채널로 보내야됨
        if(msgType == MsgType.CREATE) { // POST
            // api server call
            ((ContentCreateDto) messageDto).setSendTime((apiHelper.getCurrentTime()));
            ((ContentCreateDto) messageDto).setContentId(("aasdasdasd"));
        } else if(msgType == MsgType.UPDATE) { // PUT
            // api server call
            ((ContentUpdateDto) messageDto).setSendTime((apiHelper.getCurrentTime()));
        } else if(msgType == MsgType.DELETE) { // DELETE
            // api server call
            ((ContentDeleteDto) messageDto).setSendTime((apiHelper.getCurrentTime()));
        } else if(msgType == MsgType.JOIN) { // POST
            // api server call
            ((InMessage) messageDto).setSendTime((apiHelper.getCurrentTime()));
        } else if(msgType == MsgType.LEAVE) { // POST
            // api server call
            ((OutMessage) messageDto).setSendTime((apiHelper.getCurrentTime()));
        }

        return messageDto;
    }
}
