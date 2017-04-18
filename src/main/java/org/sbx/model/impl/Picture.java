package org.sbx.model.impl;

import org.sbx.model.DBObject;

public class Picture implements DBObject {

    private int picId;
    private String picLink;
    private String picDesc;


    public int getPicId() {
        return picId;
    }

    public void setPicId(int picId) {
        this.picId = picId;
    }

    public String getPicLink() {
        return picLink;
    }

    public void setPicLink(String picLink) {
        this.picLink = picLink;
    }

    public String getPicDesc() {
        return picDesc;
    }

    public void setPicDesc(String picDesc) {
        this.picDesc = picDesc;
    }
}
