package com.nexters.duckjiduckji.Dto;

import com.nexters.duckjiduckji.Const.MsgType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class OutMessage implements Message {
    @Builder.Default
    private MsgType msgType = MsgType.LEAVE;
    private String userId;
    private String sendTime;
}
