package com.nexters.duckjiduckji.Dto;

import com.nexters.duckjiduckji.Const.MsgType;
import lombok.*;

@Builder
@Getter
@ToString
public class InDto extends MessageDto {

    @Builder.Default
    private MsgType msgType = MsgType.JOIN;
    private String userId;
    private String sendTime;
}
