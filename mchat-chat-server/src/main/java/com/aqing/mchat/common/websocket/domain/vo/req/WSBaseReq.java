package com.aqing.mchat.common.websocket.domain.vo.req;

import com.aqing.mchat.common.websocket.domain.enums.WSReqTypeEnum;
import lombok.Data;

/**
 * Description:
 * Author: <a href="https://github.com/zongzibinbin">aqing</a>
 * Date: 2023-08-27
 */
@Data
public class WSBaseReq {
    /**
     * @see WSReqTypeEnum
     */
    private Integer type;
    private String data;
}
