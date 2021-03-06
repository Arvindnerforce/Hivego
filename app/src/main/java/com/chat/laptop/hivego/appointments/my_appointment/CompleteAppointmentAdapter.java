package com.chat.laptop.hivego.appointments.my_appointment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.chat.laptop.hivego.R;
import com.chat.laptop.hivego.appointments.cancel_appointment.ManageCancelAppointmentFragment;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by John on 10/28/2016.
 */
public class CompleteAppointmentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int SIMPLE_TYPE = 0;
    private static final int IMAGE_TYPE = 1;
    private final LayoutInflater inflater;
    private List<CompleteAppointmentData> itemList;
    Button trendingButton;
    private Context context;
    CompleteAppointmentHolder viewHolder;

    public CompleteAppointmentAdapter(Context context, List<CompleteAppointmentData> itemList)
    {
        this.itemList = itemList;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {

        View view = inflater.inflate(R.layout.row_my_appointment, parent, false);
        viewHolder = new CompleteAppointmentHolder(view);

        return viewHolder;
    }



    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position)
    {

        CompleteAppointmentHolder homeHolder = (CompleteAppointmentHolder) holder;


        homeHolder.my_aapointment_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ManageCancelAppointmentFragment manageCancelAppointmentFragment = new ManageCancelAppointmentFragment();
                Bundle bundle = new Bundle();
                bundle.putString("complete_appointment", "Complete");
                manageCancelAppointmentFragment.setArguments(bundle);
                FragmentManager fragmentManager = ((AppCompatActivity)context).getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction search_fragmentTransaction = fragmentManager.beginTransaction();
                search_fragmentTransaction.replace(R.id.frame, manageCancelAppointmentFragment);
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