package com.nexters.duckjiduckji.Dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.nexters.duckjiduckji.Const.MsgType;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "msgType",
        visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(name = "JOIN", value = InMessage.class),
        @JsonSubTypes.Type(name = "LEAVE", value = OutMessage.class),
        @JsonSubTypes.Type(name = "CREATE", value = ContentCreateDto.class),
        @JsonSubTypes.Type(name = "UPDATE", value = ContentUpdateDto.class),
        @JsonSubTypes.Type(name = "DRAG", value = ContentUpdateDto.class),
        @JsonSubTypes.Type(name = "DELETE", value = ContentDeleteDto.class)
})
public interface Message {
    MsgType getMsgType();
}
