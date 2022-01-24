package com.nexters.duckjiduckji.Dto;

import com.nexters.duckjiduckji.Const.MsgType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class OutDto extends MessageDto {
    @Builder.Default
    private MsgType msgType = MsgType.LEAVE;
    private String userId;
    private String sendTime;
}
