package com.nexters.duckjiduckji.Dto;

import com.nexters.duckjiduckji.Const.MsgType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.lang.Nullable;

@Builder
@Getter
@ToString
public class PolaroidContentDeleteDto extends MessageDto{
    @Builder.Default
    private MsgType msgType = MsgType.DELETE;
    private String contentType; // "PORAROID", "POSTIT"
    private String sendTime;
}

