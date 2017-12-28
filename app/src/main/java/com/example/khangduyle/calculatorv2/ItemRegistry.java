package com.example.khangduyle.calculatorv2;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * Created by KHANGDUYLE on 23/12/2017.
 */

public class ItemRegistry {
    private Hashtable<String,Item> map = new Hashtable<String,Item>();
    public ItemRegistry(){
        loadCache();
    }

    public Item createBasicItem(String type) throws CloneNotSupportedException{
        return map.get(type).Clone();
    }

    private void loadCache() {
        Book book = new Book();
        book.setName("Design Patterns");
        book.setPrice(20.0);

        map.put("Book", book);
        CD cd = new CD();
        cd.setName("Various");
        cd.setPrice(10.00);
        map.put("CD", cd);
    }

}

