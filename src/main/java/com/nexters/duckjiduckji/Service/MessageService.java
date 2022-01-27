package com.nexters.duckjiduckji.Service;

import com.nexters.duckjiduckji.Const.MsgType;
import com.nexters.duckjiduckji.Dto.*;
import com.nexters.duckjiduckji.Exception.type.ApiServerException;
import com.nexters.duckjiduckji.Util.ApiHelper;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
@Slf4j
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
    public Message MessageCreateService(Message message, String roomId) {
        //String contentId = callApiServer(apiServerUrl, HttpMethod.POST, message, jsonHeader, message.getClass());
        ((ContentCreateDto) message).setContentId("aaaaaa");
        ((ContentCreateDto) message).setSendTime((apiHelper.getCurrentTime()));
        return message;
    }

    // UPDATE
    public Message MessageUpdateService(Message message, String roomId) {
       //callApiServer(apiServerUrl, HttpMethod.PUT, message, jsonHeader, message.getClass());
        ((ContentUpdateDto) message).setSendTime((apiHelper.getCurrentTime()));
        return message;
    }

    // DELETE
    public Message MessageDeleteService(Message message, String roomId) {
        //callApiServer(apiServerUrl, HttpMethod.DELETE, message, jsonHeader, message.getClass());
        ((ContentDeleteDto) message).setSendTime((apiHelper.getCurrentTime()));
        return message;
    }

    // IN
    public Message MessageInService(Message message, String roomId) {
        //callApiServer(apiServerUrl, HttpMethod.POST, message, jsonHeader, message.getClass());
        if(true) throw new ApiServerException(roomId);

        ((InMessage) message).setSendTime((apiHelper.getCurrentTime()));
        return message;
    }

    // OUT
    public Message MessageOutService(Message message, String roomId) {
        //callApiServer(apiServerUrl, HttpMethod.POST, message, jsonHeader, message.getClass());
        ((OutMessage) message).setSendTime((apiHelper.getCurrentTime()));
        return message;
    }


    public String callApiServer(String apiServerInfo, HttpMethod httpMethod, Object body, HttpHeaders headers, Class clazz) {

        apiServerInfo = "http://localhost:8888/test";
        HttpEntity<Object> entity = new HttpEntity<>(body, headers);
        ResponseEntity apiResponse = null;

        apiResponse = restTemplate.exchange(apiServerInfo, httpMethod, entity, clazz);

        String className = clazz.getName().split(".")[4]; // com.nexters.duckjuduckj.Dto.ContentCreateDto
        log.info(apiResponse.toString());

        // response에서 content id만 파싱해서 응답
        if(className.equals("ContentCreateDto")) return "id";
        else return null;
    }
}
