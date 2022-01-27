package com.nexters.duckjiduckji.Dto;

import com.nexters.duckjiduckji.Const.MsgType;
import lombok.*;

@Builder
@Getter
@Setter
@ToString
public class ErrorMessage implements Message {
    @Builder.Default
    private MsgType msgType = MsgType.ERROR;
    private String roomId;
    private String sendTime;
}
