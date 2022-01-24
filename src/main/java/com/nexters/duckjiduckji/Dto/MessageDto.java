package com.nexters.duckjiduckji.Dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "msgType",
        visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(name = "JOIN", value = InDto.class),
        @JsonSubTypes.Type(name = "LEAVE", value = OutDto.class),
        @JsonSubTypes.Type(name = "CREATE", value = PolaroidContentCreateDto.class),
        @JsonSubTypes.Type(name = "UPDATE", value = PolaroidContentUpdateDto.class),
        @JsonSubTypes.Type(name = "DRAG", value = PolaroidContentUpdateDto.class),
        @JsonSubTypes.Type(name = "DELETE", value = PolaroidContentDeleteDto.class)
})
@Getter
@ToString
public abstract class MessageDto {
}
