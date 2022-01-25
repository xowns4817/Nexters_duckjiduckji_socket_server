package com.nexters.duckjiduckji.Dto;

import com.nexters.duckjiduckji.Const.MsgType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

@Builder
@Getter
@Setter
@ToString
public class PolaroidContentUpdateDto implements MessageDto{
    @Builder.Default
    private MsgType msgType = MsgType.UPDATE;
    private String contentType; // "PORAROID", "POSTIT"
    private String contentId;
    private PolaroidInnerData data;
    private String sendTime;
}
