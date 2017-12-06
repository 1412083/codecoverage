package com.example.khangduyle.calculatorv2;

/**
 * Created by KHANGDUYLE on 05/12/2017.
 */

public class PhanSo{
    int mTuSo;
    int mMauSo;
    public  PhanSo(int tu, int mau){
        mTuSo = tu;
        mMauSo = mau;
    }

    public int getMau(){
        return mMauSo;
    }

    public int getTu(){
        return mTuSo;
    }

    public void setMau(int mau){
        mMauSo= mau;
    }

    public void setTu(int tu){
        mTuSo = tu;
    }

    public void reset(){
        mTuSo = 0;
        mMauSo = 1;
    }

    public boolean checkPhanSo(){
        if (mMauSo==0){
            return false;
        }
        return true;
    }

    private boolean checkNum(String num){

        int i=0;
        int n=num.length();
        while ((i<n) &&(num.charAt(i)=='+' || num.charAt(i)=='-')){
            i++;
        }
        if (i>1){
            return false;
        }
        int s=0;
        while (i<n){
            s= num.charAt(i)-48;
            if (s<0 || s>9){
                return false;
            }
            i++;
        }

        return true;
    }

    private int makeNum(String num){
        int s=0;
        int sign =1;
        int i=0;
        if (num.charAt(0)=='-'||num.charAt(0)=='+'){
            i=1;
        }
        if (num.charAt(0)=='-'){
            sign =-1;
        }
        int n=num.length();
        while (i<n){
            s=s*10 +  num.charAt(i)-48;
            i++;
        }

        return s*sign;
    }

    public boolean setPhanSo(String str){
        String array1[]= str.split("/");
        //Không tách ra dc

        if (array1.length>2 || array1.length<1){
            return false;
        }
        if (array1.length==1){
            if (checkNum(array1[0])){
                mTuSo = makeNum(array1[0]);
                mMauSo =1;
            } else {
                return false;
            }
        } else {
            if (checkNum(array1[0]) && checkNum(array1[1])){
                mTuSo = makeNum(array1[0]);
                mMauSo = makeNum(array1[1]);
                if (mMauSo==0){
                    return false;
                }
            } else {
                return false;
            }
        }

        return true;
    }

    public float getValue(){
        return  (float)mTuSo/mMauSo;
    }

    public String getString(){
        String str;
        if (mMauSo==1){
            str = Integer.toString(mTuSo);
        } else {
            str = Integer.toString(mTuSo)+"/"+Integer.toString(mMauSo);
        }

        return str;
    }

}
