package com.chat.laptop.hivego.services.nailfragment;

import java.util.ArrayList;

/**
 * Created by John on 10/20/2016.
 */
public class NailData {

    public String image, title, price;
    ArrayList<ServiceDetailData> sellerAnswerDatas;

    NailData(ArrayList<ServiceDetailData> sellerAnswerDatas, String price)
    {
       this.sellerAnswerDatas = sellerAnswerDatas;
        this.price = price;
    }
}
