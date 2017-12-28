package com.example.khangduyle.calculatorv2;

/**
 * Created by KHANGDUYLE on 23/12/2017.
 */

public abstract class Item implements Cloneable{
    private String mName;
    private double mPrice;
    public  Item Clone() throws CloneNotSupportedException{
        Item newItem = (Item)super.clone();
        return newItem;
    }

    public String getName(){
        System.out.println("Name of item "+this.mName);
        return mName;
    }

    public double getPrice(){
        return mPrice;
    }

    public void setName(String name){

        this.mName =name;
    }

    public void setPrice(double price){
        this.mPrice = price;
    }
}
