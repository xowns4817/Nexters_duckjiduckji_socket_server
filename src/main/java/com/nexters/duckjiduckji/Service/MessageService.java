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
    public MsgType getMsgType(MessageDto messageDto) {
        if(messageDto instanceof PolaroidContentCreateDto) return MsgType.CREATE;
        else if(messageDto instanceof PolaroidContentUpdateDto) return MsgType.UPDATE;
        else if(messageDto instanceof PolaroidContentDeleteDto) return MsgType.DELETE;
        else if(messageDto instanceof InDto) return MsgType.JOIN;
        else if(messageDto instanceof OutDto) return MsgType.LEAVE;
        else return null;
    };

    public MessageDto callApiServer(MessageDto messageDto) {

        MsgType msgType = getMsgType(messageDto);
        // 폴라로이드 생성 요청 일때는 만들어진 폴라로이드 ID 추가해서 sub 채널로 보내야됨
        if(msgType == MsgType.CREATE) { // POST
            // api server call
            ((PolaroidContentCreateDto) messageDto).setSendTime((apiHelper.getCurrentTime()));
            ((PolaroidContentCreateDto) messageDto).setContentId(("aasdasdasd"));
        } else if(msgType == MsgType.UPDATE) { // PUT
            // api server call
            ((PolaroidContentUpdateDto) messageDto).setSendTime((apiHelper.getCurrentTime()));
        } else if(msgType == MsgType.DELETE) { // DELETE
            // api server call
            ((PolaroidContentDeleteDto) messageDto).setSendTime((apiHelper.getCurrentTime()));
        } else if(msgType == MsgType.JOIN) { // POST
            // api server call
            ((InDto) messageDto).setSendTime((apiHelper.getCurrentTime()));
        } else if(msgType == MsgType.LEAVE) { // POST
            // api server call
            ((OutDto) messageDto).setSendTime((apiHelper.getCurrentTime()));
        }

        return messageDto;
    }
}
