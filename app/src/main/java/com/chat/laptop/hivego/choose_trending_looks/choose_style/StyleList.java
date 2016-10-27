package com.chat.laptop.hivego.choose_trending_looks.choose_style;

import java.util.ArrayList;

/**
 * Created by John on 10/26/2016.
 */
public class StyleList {


    public String title, price;
    int image;

    StyleList(int image, String title, String price)
    {
        this.image = image;
        this.title = title;
        this.price = price;
    }
}
