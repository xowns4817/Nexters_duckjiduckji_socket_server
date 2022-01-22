package com.nexters.duckjiduckji.Dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PolaroidPositionDto {
    private String msgType;
    private String polaroidId;
    private int posX;
    private int posY;
    private int rotation;
    private String sendTime;
}
