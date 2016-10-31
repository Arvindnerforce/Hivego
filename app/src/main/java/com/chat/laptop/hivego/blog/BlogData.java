package com.chat.laptop.hivego.blog;

/**
 * Created by John on 10/31/2016.
 */
public class BlogData {

    public String title, price;
    int image;

    BlogData(int image, String title, String price)
    {
        this.image = image;
        this.title = title;
        this.price = price;
    }
}
