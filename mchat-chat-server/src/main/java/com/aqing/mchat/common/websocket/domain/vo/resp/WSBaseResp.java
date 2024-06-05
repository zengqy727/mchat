package com.aqing.mchat.common.websocket.domain.vo.resp;

import com.aqing.mchat.common.websocket.domain.enums.WSRespTypeEnum;

/**
 * Description:
 * Author: <a href="https://github.com/zongzibinbin">aqing</a>
 * Date: 2023-08-27
 */
public class WSBaseResp<T> {
    /**
     * @see WSRespTypeEnum
     */
    private Integer type;
    private T data;
}
