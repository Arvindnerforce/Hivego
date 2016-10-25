package com.chat.laptop.hivego.appointments;

import android.content.Context;
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
 * Created by John on 10/25/2016.
 */
public class ManageAppointmentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int SIMPLE_TYPE = 0;
    private static final int IMAGE_TYPE = 1;
    private final LayoutInflater inflater;
    private List<ManageAppointmentData> itemList;
    private Context context;
    ManageAppointmentHolder viewHolder;

    public ManageAppointmentAdapter(Context context, List<ManageAppointmentData> itemList)
    {
        this.itemList = itemList;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {

        View view = inflater.inflate(R.layout.row_manage_appointment, parent, false);
        viewHolder = new ManageAppointmentHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position)
    {

        ManageAppointmentHolder homeHolder = (ManageAppointmentHolder) holder;

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