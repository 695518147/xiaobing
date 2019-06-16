package com.zpy.xiaobingservice.base;

import lombok.Data;

@Data
public class PageVo {

    private int pageNum = 0;
    private int pageSize = 10;
    private String orderBy = "number asc";

}
