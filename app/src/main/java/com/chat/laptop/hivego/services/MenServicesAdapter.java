package com.chat.laptop.hivego.services;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.chat.laptop.hivego.R;
import com.chat.laptop.hivego.services.nailfragment.NailFragment;
import com.chat.laptop.hivego.services.services_tab.ServicesTabFragment;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by John on 9/7/2016.
 */
public class MenServicesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{

    private static final int SIMPLE_TYPE = 0;
    private static final int IMAGE_TYPE = 1;
    private final LayoutInflater inflater;
    private List<MenServicesData> itemList;
    private Context context;
    MenServicesHolder viewHolder;


    public MenServicesAdapter(Context context, List<MenServicesData> itemList) {
        this.itemList = itemList;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = inflater.inflate(R.layout.row_services, parent, false);
        viewHolder = new MenServicesHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position)
    {
        MenServicesHolder homeHolder = (MenServicesHolder) holder;

        homeHolder.salon_name.setText(itemList.get(position).price.toString());

        System.out.println("image=============="+ itemList.get(position).image);

        Picasso.with(context).load(itemList.get(position).image).into(homeHolder.men_image);

        homeHolder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

                ServicesTabFragment servicesTabFragment = new ServicesTabFragment();
                FragmentManager fragmentManager = ((AppCompatActivity)context).getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction search_fragmentTransaction = fragmentManager.beginTransaction();
                search_fragmentTransaction.replace(R.id.frame, servicesTabFragment);
                search_fragmentTransaction.addToBackStack(null);
                search_fragmentTransaction.commit();

            }
        });



    }

    private void showMessage(String s) {
        Toast.makeText(context, s, Toast.LENGTH_SHORT).show();
    }


    @Override
    public int getItemCount()
    {
        return itemList.size();
        //return itemList.size();
    }

    public String getCurrentTimeStamp() {
        return new SimpleDateFormat("dd MMM yyyy HH:mm").format(new Date());
    }
}
