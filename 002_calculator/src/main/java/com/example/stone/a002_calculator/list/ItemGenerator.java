package com.example.stone.a002_calculator.list;

public class ItemGenerator {
    String  language;
    int icon;
    boolean noti;
    String  pCount;
    public ItemGenerator(String language,int icon) {
        this.language = language;
        this.icon = icon;
    }

    public ItemGenerator(String language,int icon,boolean noti,String pCount) {
        this.language = language;
        this.icon = icon;
        this.noti = noti;
        this.pCount = pCount;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public boolean isNoti() {
        return noti;
    }

    public void setNoti(boolean noti) {
        this.noti = noti;
    }

    public String getpCount() {
        return pCount;
    }

    public void setpCount(String pCount) {
        this.pCount = pCount;
    }
}
