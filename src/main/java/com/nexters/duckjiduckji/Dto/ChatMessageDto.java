package com.nexters.duckjiduckji.Dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ChatMessageDto {
    private String roomId;
    private String writer;
    private String message;
}
