package com.aqing.mchat.common.common.domain.dto;

import lombok.Data;

/**
 * Description: web请求信息收集类
 * Author: <a href="https://github.com/zengqy727">aqing</a>
 * Date: 2023-04-05
 */
@Data
public class RequestInfo {
    private Long uid;
    private String ip;
}
