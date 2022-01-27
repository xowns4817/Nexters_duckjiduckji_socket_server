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

    // CREATE
    public Message MessageCreateService(Message message) {
        //call api server
        ((ContentCreateDto) message).setContentId(("aasdasdasd"));
        ((ContentCreateDto) message).setSendTime((apiHelper.getCurrentTime()));
        return message;
    }

    // UPDATE
    public Message MessageUpdateService(Message message) {
        // call api server
        ((ContentUpdateDto) message).setSendTime((apiHelper.getCurrentTime()));
        return message;
    }

    public Message MessageDeleteService(Message message) {
        // call api server
        ((ContentDeleteDto) message).setSendTime((apiHelper.getCurrentTime()));
        return message;
    }

    public Message MessageInService(Message message) {
        // call api server
        ((InMessage) message).setSendTime((apiHelper.getCurrentTime()));
        return message;
    }

    public Message MessageOutService(Message message) {
        // call api server
        ((OutMessage) message).setSendTime((apiHelper.getCurrentTime()));
        return message;
    }
}
