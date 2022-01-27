package com.nexters.duckjiduckji.Dto;

import lombok.*;

@Builder
@Getter
@ToString
public class ContentInnerData { // default 값 설정
    private String imgUrl;
    private String title;
    private String content;
    private String width;
    private String height;
    private String opacity;
    private String font;
    private ContentPositionData point;
}
