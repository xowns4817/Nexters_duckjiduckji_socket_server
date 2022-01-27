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
public class ContentDeleteDto implements Message {
    @Builder.Default
    private MsgType msgType = MsgType.DELETE;
    private String contentId;
    private String contentType; // "PORAROID", "POSTIT"
    private String sendTime;

    @Override
    public MsgType getMsgType() {
        return msgType;
    }
}

