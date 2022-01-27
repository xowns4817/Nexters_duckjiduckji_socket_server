package com.nexters.duckjiduckji.Dto;

import com.nexters.duckjiduckji.Const.MsgType;
import lombok.*;

@Builder
@Getter
@Setter
@ToString
public class InMessage implements Message {

    @Builder.Default
    private MsgType msgType = MsgType.JOIN;
    private String userId;
    private String sendTime;

    @Override
    public MsgType getMsgType() {
        return msgType;
    }
}
