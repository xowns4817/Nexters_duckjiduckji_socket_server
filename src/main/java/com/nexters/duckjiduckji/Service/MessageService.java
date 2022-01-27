package com.nexters.duckjiduckji.Service;

import com.nexters.duckjiduckji.Const.MsgType;
import com.nexters.duckjiduckji.Dto.*;
import com.nexters.duckjiduckji.Util.ApiHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MessageService {

    private final RestTemplate restTemplate;
    private final ApiHelper apiHelper;
    private final HttpHeaders jsonHeader;

    @Value("${api.server.info")
    private String apiServerUrl;

    public MessageService(RestTemplate restTemplate, ApiHelper apiHelper, @Qualifier("application-json-header") HttpHeaders jsonHeader) {
        this.restTemplate = restTemplate;
        this.apiHelper = apiHelper;
        this.jsonHeader = jsonHeader;
    }

    // CREATE
    public Message MessageCreateService(Message message) {
        callApiServer(apiServerUrl, HttpMethod.POST, message, jsonHeader, message.getClass());
        ((ContentCreateDto) message).setContentId(("aasdasdasd"));
        ((ContentCreateDto) message).setSendTime((apiHelper.getCurrentTime()));
        return message;
    }

    // UPDATE
    public Message MessageUpdateService(Message message) {
        callApiServer(apiServerUrl, HttpMethod.PUT, message, jsonHeader, message.getClass());
        ((ContentUpdateDto) message).setSendTime((apiHelper.getCurrentTime()));
        return message;
    }

    // DELETE
    public Message MessageDeleteService(Message message) {
        callApiServer(apiServerUrl, HttpMethod.DELETE, message, jsonHeader, message.getClass());
        ((ContentDeleteDto) message).setSendTime((apiHelper.getCurrentTime()));
        return message;
    }

    // IN
    public Message MessageInService(Message message) {
        callApiServer(apiServerUrl, HttpMethod.POST, message, jsonHeader, message.getClass());
        ((InMessage) message).setSendTime((apiHelper.getCurrentTime()));
        return message;
    }

    // OUT
    public Message MessageOutService(Message message) {
        callApiServer(apiServerUrl, HttpMethod.POST, message, jsonHeader, message.getClass());
        ((OutMessage) message).setSendTime((apiHelper.getCurrentTime()));
        return message;
    }


    public void callApiServer(String apiServerInfo, HttpMethod httpMethod, Object params, HttpHeaders headers, Class clazz) {

        HttpEntity<Object> entity = new HttpEntity<>(params, headers);
        ResponseEntity apiResponse = null;

        apiResponse = restTemplate.exchange(apiServerInfo, httpMethod, entity, clazz);
        System.out.println(apiResponse.toString());
    }
}
