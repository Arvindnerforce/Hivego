package com.chat.laptop.hivego.choose_trending_looks.choose_style;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.chat.laptop.hivego.R;
import com.chat.laptop.hivego.choose_trending_looks.bread.BeardFragment;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


/**
 * Created by John on 10/26/2016.
 */
public class StyleListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{

    private static final int SIMPLE_TYPE = 0;
    private static final int IMAGE_TYPE = 1;
    private final LayoutInflater inflater;
    Context context;
    StyleHolder viewHolder;
    ArrayList<Integer> itemsimg = new ArrayList<Integer>();



    public StyleListAdapter(Context context, ArrayList<Integer> itemList)
    {


        this.itemsimg = itemList;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {

        View view = inflater.inflate(R.layout.row_choose_style, parent, false);
        viewHolder = new StyleHolder(view);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position)
    {


        viewHolder.style_image.setImageResource(itemsimg.get(position));


        viewHolder.salon_list_item.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view)
            {

                viewHolder.check_style_image.setVisibility(View.VISIBLE);
                BeardFragment chooseStyleFragment = new BeardFragment();
                FragmentManager fragmentManager = ((AppCompatActivity) context).getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction search_fragmentTransaction = fragmentManager.beginTransaction();
                search_fragmentTransaction.replace(R.id.frame, chooseStyleFragment);
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
        return itemsimg.size();
//        return itemList.size();
    }

    public String getCurrentTimeStamp() {
        return new SimpleDateFormat("dd MMM yyyy HH:mm").format(new Date());
    }
}

