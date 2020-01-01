package com.heyefu.template.pojo.app;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Description:
 *
 * @author heyefu
 * Create in: 2019-12-31
 * Time: 15:35
 **/
@Getter
@Setter
@ToString
public class Topics {
    private String labelText;
    private String paragraphText;
    private String voteBtnText;
    private Option[] opinions;
}
