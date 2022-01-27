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
public class ContentUpdateDto implements Message {
    @Builder.Default
    private MsgType msgType = MsgType.UPDATE;
    private String contentType; // "PORAROID", "POSTIT"
    private String contentId;
    private ContentInnerData data;
    private String sendTime;

    @Override
    public MsgType getMsgType() {
        return msgType;
    }
}
