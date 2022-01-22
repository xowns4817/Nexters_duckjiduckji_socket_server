package com.nexters.duckjiduckji.Dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PolaroidContentDto {
    private String msgType; // 메시지 type
    private String polaroidId;
    private String imgUrl;
    private String title;
    private String content;
    private String sendTime;
}
