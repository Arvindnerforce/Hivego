package com.chat.laptop.hivego.appointments;

/**
 * Created by John on 10/25/2016.
 */
public class AppointmentDetailsData {

    public String service_name, price,total_service_product;

    AppointmentDetailsData(String service_name, String price, String total_service_product)
    {
        this.service_name = service_name;
        this.price = price;
        this.total_service_product = total_service_product;
    }


}
