package com.qibei.gugu.model;

import android.graphics.Bitmap;

/**
 * 我的   功能导航列表中   bean
 */
public class Myfunction {
    private String text;
    private Bitmap src;

    public Myfunction(String text, Bitmap src) {
        this.text = text;
        this.src = src;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Bitmap getSrc() {
        return src;
    }

    public void setSrc(Bitmap src) {
        this.src = src;
    }
}
