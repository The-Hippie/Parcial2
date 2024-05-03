package com.example.adaptaon;

import java.io.Serializable;

public class ListElement implements Serializable {

    public String name;
    public String pc;
    public String status;

    public String imageurl;





    public ListElement(String name, String pc, String status, String imageurl) {

        this.imageurl= imageurl;
        this.name = name;
        this.pc = pc;
        this.status = status;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPc() {
        return pc;
    }

    public void setPc(String pc) {
        this.pc = pc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
