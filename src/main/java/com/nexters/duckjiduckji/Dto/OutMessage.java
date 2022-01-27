package com.nexters.duckjiduckji.Dto;

import com.nexters.duckjiduckji.Const.MsgType;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class OutMessage implements Message {

    private MsgType msgType = MsgType.LEAVE;
    private String userId;
    private String sendTime;
}
