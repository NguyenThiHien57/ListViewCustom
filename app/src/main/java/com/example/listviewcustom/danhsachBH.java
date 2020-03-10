package com.example.listviewcustom;

public class danhsachBH  {
    int anh1,anh2;
    String tenBH,tacGia,Time;

    public danhsachBH(int anh1, int anh2, String tenBH, String tacGia, String time) {
        this.anh1 = anh1;
        this.anh2 = anh2;
        this.tenBH = tenBH;
        this.tacGia = tacGia;
        Time = time;
    }
    public danhsachBH() {
    }

    public int getAnh1() {
        return anh1;
    }

    public void setAnh1(int anh1) {
        this.anh1 = anh1;
    }

    public int getAnh2() {
        return anh2;
    }

    public void setAnh2(int anh2) {
        this.anh2 = anh2;
    }

    public String getTenBH() {
        return tenBH;
    }

    public void setTenBH(String tenBH) {
        this.tenBH = tenBH;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }
}
