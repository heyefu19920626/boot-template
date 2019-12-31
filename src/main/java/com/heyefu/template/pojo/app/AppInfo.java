package com.heyefu.template.pojo.app;

/**
 * Description:
 *
 * @author heyefu
 * Create in: 2019-12-31
 * Time: 15:24
 **/
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

    public Topics getTopics() {
        return topics;
    }

    public void setTopics(Topics topics) {
        this.topics = topics;
    }

    public ScheduleInfo getScheduleInfo() {
        return scheduleInfo;
    }

    public void setScheduleInfo(ScheduleInfo scheduleInfo) {
        this.scheduleInfo = scheduleInfo;
    }

    public PosSize getSdPosSize() {
        return sdPosSize;
    }

    public void setSdPosSize(PosSize sdPosSize) {
        this.sdPosSize = sdPosSize;
    }

    public PosSize getUhdPosSize() {
        return uhdPosSize;
    }

    public void setUhdPosSize(PosSize uhdPosSize) {
        this.uhdPosSize = uhdPosSize;
    }

    public PosSize getHdPosSize() {
        return hdPosSize;
    }

    public void setHdPosSize(PosSize hdPosSize) {
        this.hdPosSize = hdPosSize;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getOpacity() {
        return opacity;
    }

    public void setOpacity(double opacity) {
        this.opacity = opacity;
    }

    public boolean getIs_forced() {
        return is_forced;
    }

    public void setIs_forced(boolean is_forced) {
        this.is_forced = is_forced;
    }
}
