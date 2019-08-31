package com.zpy.zpyupload.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class UploadResult {
    /**
     * url : /media/image/订单管理_20190901013754_921.png
     * original : 订单管理.png
     * type : .png
     * state : SUCCESS
     * size : 91314
     */

    private String url;
    private String original;
    private String type;
    private String state;
    private Long size;
}
