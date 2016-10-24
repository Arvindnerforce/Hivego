package com.chat.laptop.hivego.confirm_fragment;

import com.chat.laptop.hivego.services.nailfragment.ServiceDetailData;

import java.util.ArrayList;

/**
 * Created by John on 10/24/2016.
 */
public class ConfirmOrderData
{

    public String service_name, price,total_service_product;

    ConfirmOrderData(String service_name, String price,String total_service_product)
    {
        this.service_name = service_name;
        this.price = price;
        this.total_service_product = total_service_product;
     }



}
