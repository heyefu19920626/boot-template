package com.heyefu.template.pojo.app;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Description:
 *
 * @author heyefu
 * Create in: 2019-12-31
 * Time: 15:25
 **/
@Getter
@Setter
@ToString
public class ScheduleInfo {
    private long playTime;
    private String chnlName;
    private long stopTime;
    private String postUrl;
    private String anyUrl;
}
