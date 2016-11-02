package com.chat.laptop.hivego.confirm_fragment;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.chat.laptop.hivego.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by John on 10/24/2016.
 */
public class ConfirmOrderAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int SIMPLE_TYPE = 0;
    private static final int IMAGE_TYPE = 1;
    private final LayoutInflater inflater;
    ArrayList<Integer> values=new ArrayList<>();
    private List<ConfirmOrderData> itemList;
    private Context context;
    ConfirmOrderHolder viewHolder;

    public ConfirmOrderAdapter(Context context, List<ConfirmOrderData> itemList)
    {
        this.itemList = itemList;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {

        View view = inflater.inflate(R.layout.row_confirm_order, parent, false);
        viewHolder = new ConfirmOrderHolder(view);


        try
        {
            values.clear();
        }
        catch (Exception ex)
        {

        }


        for(int i=0;i<itemList.size();i++)
        {
            values.add(1);
        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position)
    {

        viewHolder.textView_service_name.setText(itemList.get(position).service_name);

        viewHolder.textView_service_total_price.setText(itemList.get(position).total_service_product);

        //  viewHolder.services_value.setText(values.get(position).toString());

        viewHolder.increament_Service.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                values.set(position, values.get(position) + 1);
                viewHolder.textView_services_value.setText(values.get(position).toString());
                notifyDataSetChanged();
                Toast.makeText(context, "clicked increment:"+values.get(position).toString(), Toast.LENGTH_SHORT).show();

            }
        });


        viewHolder.decreament_Service.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Toast.makeText(context, "clicked decrement:"+position, Toast.LENGTH_SHORT).show();
                if(values.get(position) > 0) {

                    values.set(position, values.get(position) - 1);
                    viewHolder.textView_services_value.setText(values.get(position).toString());
                    notifyDataSetChanged();

                }

            }
        });



       /* homeHolder.nail_linearlayout.setOnClickListener(new View.OnClickListener() {
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
        });*/



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