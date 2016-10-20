package com.chat.laptop.hivego.services.nailfragment;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
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
 * Created by John on 10/20/2016.
 */
public class NailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int SIMPLE_TYPE = 0;
    private static final int IMAGE_TYPE = 1;
    private final LayoutInflater inflater;
    private List<NailData> itemList;
    private Context context;
    NailHolder viewHolder;
    Service_details_Adapter service_details_adapter;

    public NailAdapter(Context context, List<NailData> itemList)
    {
        this.itemList = itemList;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {

        View view = inflater.inflate(R.layout.row_nail, parent, false);
        viewHolder = new NailHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position)
    {

        NailHolder homeHolder = (NailHolder) holder;

        homeHolder.service_tittle.setText(itemList.get(position).price.toString());


        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        homeHolder.recyclerView.setLayoutManager(layoutManager);
        service_details_adapter = new Service_details_Adapter(context, itemList.get(position).sellerAnswerDatas);
        homeHolder.recyclerView.setAdapter(service_details_adapter);


        homeHolder.nail_linearlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

                NailFragment salonListFragment = new NailFragment();
                FragmentManager fragmentManager = ((AppCompatActivity)context).getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction search_fragmentTransaction = fragmentManager.beginTransaction();
                search_fragmentTransaction.replace(R.id.frame, salonListFragment);
                search_fragmentTransaction.addToBackStack(null);
                search_fragmentTransaction.commit();

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

