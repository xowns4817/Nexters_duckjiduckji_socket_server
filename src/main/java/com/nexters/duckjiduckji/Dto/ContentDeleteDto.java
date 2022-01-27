package com.nexters.duckjiduckji.Dto;

import com.nexters.duckjiduckji.Const.MsgType;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ContentDeleteDto implements Message {

    private MsgType msgType = MsgType.DELETE;
    private String contentId;
    private String contentType; // "PORAROID", "POSTIT"
    private String sendTime;
}

