package com.example.khangduyle.calculatorv2;

/**
 * Created by KHANGDUYLE on 31/12/2017.
 */

public class TamGiac {
    private Diem _a;



    public Diem getA(){
        return _a;
    }

    public void setA(Diem v){
        _a=v;
    }
    private Diem _b;


    public Diem getB(){
        return _b;
    }

    public void setB(Diem v){
        _b=v;
    }
    private Diem _c;


    public Diem getC(){
        return _c;
    }

    public void setC(Diem v){
        _c=v;
    }

    /*
     * Ham khoi tao khong tham so
     * Dinh A,B,C deu co toa do 0,0
     */
    public TamGiac()
    {
        _a = new Diem(0, 0);
        _b = new Diem(0, 0);
        _c = new Diem(0, 0);
    }

    /*
     * Ham khoi tao 3 tham so Diem
     * Dinh A,B,C bang 3 tham so
     */
    public TamGiac(Diem a, Diem b, Diem c)
    {
        _a = a;
        _b = b;
        _c = c;
    }

    /*
     * Ham tinh chu vi
     * Ham tra ve chu vi cua tam giac
     */
    public double ChuVi()
    {
        double AB = _a.KhoangCach(_b);
        double AC = _a.KhoangCach(_c);
        double BC = _b.KhoangCach(_a);
        return AB + AC + BC;
    }

    /*
     * Ham xac dinh loai tam gia
     * Ham tra ve
     * -1: khong la tam gia
     * 0: tam giac thuong
     * 1: tam giac can
     * 2: tam giac deu
     */
    public String LoaiTamGiac()
    {
        double AB = _a.KhoangCach(_b);
        double AC = _a.KhoangCach(_c);
        double BC = _b.KhoangCach(_c);
        if ((AB + AC == BC) || (AB + BC == AC) || (AC + BC == AB)) return "Khong la tam giac";
        if (AB==AC && AB==BC) return "Tam giac can";
        if (AB == AC || AB == BC) return "Tam giac deu";

        return "Tam giac thuong";
    }
}
