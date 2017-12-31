package com.example.khangduyle.calculatorv2;

/**
 * Created by KHANGDUYLE on 31/12/2017.
 */

public class Diem {
    private double _x;


    public double getX(){
        return _x;
    }

    public void setX(double v){
        _x=v;
    }


    private double _y;



    public double getY(){
        return _y;
    }

    public void setY(double v){
        _y=v;
    }


    /*
     * Ham dung khong tham so
     * Toa do _x=0, _y=0
     */
    public Diem()
    {
        _x = 0;
        _y = 0;
    }

    /*
     * Ham dung 2 tham so nguyen x,y
     * Tham so _x=x va _y=y
     */
    public Diem(double x, double y)
    {
        _x = x;
        _y = y;
    }

    /*
     * Ham dung 1 tham so la chuoi dang "x,y"
     * Tham so _x=x va _y=y
     */
    public Diem(String chuoi)
    {
        String[] mang = chuoi.split(",");
        _x = Double.parseDouble(mang[0]);
        _y = Double.parseDouble(mang[0]);
    }

    /*
     * Ham tinh khoang cach den 1 diem khac
     * Ham tra ve gia tri khoang cach
     */
    public double KhoangCach(Diem d)
    {
        double kc = Math.sqrt((this._x - d._x) * (this._x - d._x) + (this._y - d._y) * (this._y - d._y));
        return kc;
    }

    /*
     * Ham biet diem thanh chuoi
     * Ham tra ve chuoi co dang "x,y"
     */

    public  String ToString()
    {
        return Double.toString(_x)+","+Double.toString(_y);
    }
}
