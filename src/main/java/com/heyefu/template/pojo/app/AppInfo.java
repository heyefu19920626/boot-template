package com.heyefu.template.pojo.app;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Description:
 *
 * @author heyefu
 * Create in: 2019-12-31
 * Time: 15:24
 **/
@Getter
@Setter
@ToString
public class AppInfo {
    private String appName;
    private String appVersion;
    private String status;
    private PosSize hdPosSize;
    private PosSize sdPosSize;
    private PosSize uhdPosSize;
    private Topics topics;
    private double opacity;
    private boolean is_forced;
    private ScheduleInfo scheduleInfo;

    public boolean isIs_forced() {
        return is_forced;
    }

    public void setIs_forced(boolean is_forced) {
        this.is_forced = is_forced;
    }
}
