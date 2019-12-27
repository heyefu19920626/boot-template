package com.heyefu.template.common;

import lombok.Data;

/**
 * Description:
 * <p>
 * 给前端的响应回复.
 *
 * @author heyefu
 * Create in: 2019-12-27
 * Time: 15:57
 **/
@Data
public class ResultResponse<T> {

    private boolean status;

    private int code;

    private T t;
}
