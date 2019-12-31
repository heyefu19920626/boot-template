package com.heyefu.template.pojo.app;

/**
 * Description:
 *
 * @author heyefu
 * Create in: 2019-12-31
 * Time: 15:35
 **/
public class Topics {
    private String labelText;
    private String paragraphText;
    private String voteBtnText;
    private Option[] opinions;

    public String getLabelText() {
        return labelText;
    }

    public void setLabelText(String labelText) {
        this.labelText = labelText;
    }

    public String getParagraphText() {
        return paragraphText;
    }

    public void setParagraphText(String paragraphText) {
        this.paragraphText = paragraphText;
    }

    public String getVoteBtnText() {
        return voteBtnText;
    }

    public void setVoteBtnText(String voteBtnText) {
        this.voteBtnText = voteBtnText;
    }

    public Option[] getOpinions() {
        return opinions;
    }

    public void setOpinions(Option[] opinions) {
        this.opinions = opinions;
    }
}
