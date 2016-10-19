package com.chat.laptop.hivego.salon;

import android.content.Context;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.chat.laptop.hivego.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by John on 10/19/2016.
 */
public class SalonListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int SIMPLE_TYPE = 0;
    private static final int IMAGE_TYPE = 1;
    private final LayoutInflater inflater;
    private List<SalonListData> itemList;
     Context context;
    SalonListHolder viewHolder;


    public SalonListAdapter(Context context, List<SalonListData> itemList) {
        this.itemList = itemList;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {

        View view = inflater.inflate(R.layout.row_salon_list, parent, false);
        viewHolder = new SalonListHolder(view);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position)
    {

        SalonListHolder homeHolder = (SalonListHolder) holder;

        homeHolder.salon_name.setText(itemList.get(position).price.toString());

        homeHolder.salon_list_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


              /*  SalonListFragment salonListFragment = new SalonListFragment();
                android.support.v4.app.FragmentTransaction search_fragmentTransaction = context.getSupportFragmentManager().beginTransaction();
                search_fragmentTransaction.replace(R.id.frame, salonListFragment);
                search_fragmentTransaction.addToBackStack(null);
                search_fragmentTransaction.commit();*/



            }
        });


    }

    private void showMessage(String s) {
        Toast.makeText(context, s, Toast.LENGTH_SHORT).show();
    }


    @Override
    public int getItemCount() {
        return itemList.size();
//        return itemList.size();
    }

    public String getCurrentTimeStamp() {
        return new SimpleDateFormat("dd MMM yyyy HH:mm").format(new Date());
    }
}

