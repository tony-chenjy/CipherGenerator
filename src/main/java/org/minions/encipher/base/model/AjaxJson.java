package org.minions.encipher.base.model;

import lombok.Data;

@Data
public class AjaxJson {

    // status
    public static final boolean STATUS_SUCCESS = true;
    public static final boolean STATUS_ERROR = false;

    private boolean status;
    private String info;
    private Object data;

    private AjaxJson(boolean status, String info, Object data) {
        this.status = status;
        this.info = info;
        this.data = data;
    }

    public static final AjaxJson success(String info) {
        return new AjaxJson(AjaxJson.STATUS_SUCCESS, info, null);
    }

    public static final AjaxJson success(String info, Object data) {
        return new AjaxJson(AjaxJson.STATUS_SUCCESS, info, data);
    }

    public static final AjaxJson error(String info) {
        return new AjaxJson(AjaxJson.STATUS_ERROR, info, null);
    }

    public static final AjaxJson error(String info, Object data) {
        return new AjaxJson(AjaxJson.STATUS_ERROR, info, data);
    }
}
