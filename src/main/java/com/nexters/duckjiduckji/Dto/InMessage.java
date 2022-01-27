package com.nexters.duckjiduckji.Dto;

import com.nexters.duckjiduckji.Const.MsgType;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class InMessage implements Message {

    private MsgType msgType = MsgType.JOIN;
    private String userId;
    private String sendTime;
}
