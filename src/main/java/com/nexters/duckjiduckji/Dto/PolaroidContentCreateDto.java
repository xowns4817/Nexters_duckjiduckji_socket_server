package com.nexters.duckjiduckji.Dto;

import com.nexters.duckjiduckji.Const.MsgType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.lang.Nullable;

@Builder
@Getter
@ToString
public class PolaroidContentCreateDto extends MessageDto{
    @Builder.Default
    private MsgType msgType = MsgType.CREATE;
    private String contentType; // "PORAROID", "POSTIT"
    private PolaroidInnerData data;
    private String sendTime;
}
