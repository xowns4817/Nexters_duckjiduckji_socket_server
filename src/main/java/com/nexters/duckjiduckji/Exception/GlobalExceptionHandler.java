package com.nexters.duckjiduckji.Exception;

import com.nexters.duckjiduckji.Dto.ErrorMessage;
import com.nexters.duckjiduckji.Exception.type.ApiServerException;
import com.nexters.duckjiduckji.Exception.type.SocketServerException;
import com.nexters.duckjiduckji.Util.ApiHelper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
@Slf4j
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    private final SimpMessagingTemplate template;
    private final ApiHelper apiHelper;

    @MessageExceptionHandler({ApiServerException.class})
    public void handleApiServerException(Exception e) {

        e.printStackTrace();
        String roomId = e.getMessage();

        ErrorMessage errorMessage = ErrorMessage.builder()
                                    .roomId(roomId)
                                    .sendTime(apiHelper.getCurrentTime())
                                    .build();

        template.convertAndSend("/subscribe/room/" + roomId, errorMessage);
    }
}
