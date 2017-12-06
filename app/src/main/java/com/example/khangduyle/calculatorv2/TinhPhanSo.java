package com.example.khangduyle.calculatorv2;

/**
 * Created by KHANGDUYLE on 05/12/2017.
 */

public class TinhPhanSo {

    private int MauSoChungNhoNhat(PhanSo p)
    {
        int a= p.getTu();
        int b = p.getMau();
        while (b!=0)
        {
            int r=a%b;
            a=b;
            b=r;
        }
        return a;
    }


    private PhanSo ToiGianPhanSo(PhanSo p){
        int a= p.getTu();
        int b = p.getMau();
        int r = MauSoChungNhoNhat(p);
        p.setTu(a/r);
        p.setMau(b/r);
        return p;
    }

    public PhanSo Cong(PhanSo p1, PhanSo p2){
        int mau= p1.getMau()*p2.getMau();
        int tu = p1.getTu()*p2.getMau() + p2.getTu()*p1.getMau();
        PhanSo nP= new PhanSo(tu,mau);
        return ToiGianPhanSo(nP);
    }

    public PhanSo Tru(PhanSo p1, PhanSo p2){
        int mau= p1.getMau()*p2.getMau();
        int tu = p1.getTu()*p2.getMau() - p2.getTu()*p1.getMau();
        PhanSo nP= new PhanSo(tu,mau);
        return ToiGianPhanSo(nP);
    }

    public PhanSo Nhan(PhanSo p1, PhanSo p2){
        int mau= p1.getMau()*p2.getMau();
        int tu = p1.getTu()* p2.getTu();
        PhanSo nP= new PhanSo(tu,mau);
        return ToiGianPhanSo(nP);
    }

    public PhanSo Chia(PhanSo p1, PhanSo p2){
        int mau= p1.getMau()*p2.getTu();
        int tu = p1.getTu()* p2.getMau();
        PhanSo nP= new PhanSo(tu,mau);
        return ToiGianPhanSo(nP);
    }
}
