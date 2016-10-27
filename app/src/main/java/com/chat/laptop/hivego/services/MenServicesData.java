package com.chat.laptop.hivego.services;

/**
 * Created by John on 10/17/2016.
 */
public class MenServicesData {

    public String title, price;
    int image;

    MenServicesData(int image, String title, String price)
    {
        this.image = image;
        this.title = title;
        this.price = price;
    }
}
