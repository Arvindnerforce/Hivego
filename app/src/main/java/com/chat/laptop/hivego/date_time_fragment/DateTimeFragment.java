package com.chat.laptop.hivego.date_time_fragment;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.chat.laptop.hivego.R;
import com.chat.laptop.hivego.general.WrapContentViewPager;
import com.github.ivbaranov.mfb.MaterialFavoriteButton;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.wdullaer.materialdatetimepicker.time.RadialPickerLayout;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;



public class DateTimeFragment extends Fragment implements View.OnClickListener,TimePickerDialog.OnTimeSetListener,DatePickerDialog.OnDateSetListener
{

    WrapContentViewPager viewPager;
    TabLayout tabLayout;
    MaterialFavoriteButton post_material_button,previos_material_button;
    TextView toolbar_title_txt,month_txt,month_txt_disable;

    private int[] tabIcons =
            {
            R.drawable.ic_morning,
            R.drawable.ic_afternoon,
            R.drawable.ic_moon,
            R.drawable.ic_moon
    };



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_date_time, container, false);

        setuptoolbar(view);

        setupViewPager(view);

        month_txt = (TextView) view.findViewById(R.id.month_txt);

        post_material_button = (MaterialFavoriteButton) view.findViewById(R.id.post_material_button);

        previos_material_button = (MaterialFavoriteButton) view.findViewById(R.id.previos_material_button);

        month_txt_disable = (TextView) view.findViewById(R.id.month_txt_disable);

        post_material_button.setFavorite(true, false);

        previos_material_button.setFavorite(true, false);

        month_txt.setOnClickListener((View.OnClickListener) this);

        String current_date = new SimpleDateFormat("MMMM-dd-yyyy").format(new Date());

        String date_txt = current_date.substring(0,current_date.length()-5);

        month_txt.setText(date_txt);

        month_txt_disable.setOnClickListener(((View.OnClickListener) this));

        previos_material_button.setOnFavoriteChangeListener(
                new MaterialFavoriteButton.OnFavoriteChangeListener() {
                    @Override
                    public void onFavoriteChanged(MaterialFavoriteButton buttonView, boolean favorite) {

                        SimpleDateFormat sdf = new SimpleDateFormat("MMMM-dd-yyyy");
                        Calendar c = Calendar.getInstance();
                        try {
                            c.setTime(sdf.parse(month_txt_disable.getText().toString()));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        c.add(Calendar.DATE, -1);  // number of days to add, can also use Calendar.DAY_OF_MONTH in place of Calendar.DATE
                        SimpleDateFormat sdf1 = new SimpleDateFormat("MMMM-dd-yyyy");
                        String output = sdf1.format(c.getTime());

                        String date_txt = output.substring(0, output.length() - 5);

                        month_txt.setText(date_txt);

                        month_txt_disable.setText(output);


                    }
                });


        post_material_button.setOnFavoriteChangeListener(
                new MaterialFavoriteButton.OnFavoriteChangeListener() {
                    @Override
                    public void onFavoriteChanged(MaterialFavoriteButton buttonView, boolean favorite)
                    {

                        SimpleDateFormat sdf = new SimpleDateFormat("MMMM-dd-yyyy");
                        Calendar c = Calendar.getInstance();
                        try {
                            c.setTime(sdf.parse(month_txt_disable.getText().toString()));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        c.add(Calendar.DATE, 1);  // number of days to add, can also use Calendar.DAY_OF_MONTH in place of Calendar.DATE
                        SimpleDateFormat sdf1 = new SimpleDateFormat("MMMM-dd-yyyy");
                        String output = sdf1.format(c.getTime());
                        String date_txt = output.substring(0, output.length() - 5);

                        month_txt.setText(date_txt);

                        month_txt_disable.setText(output);


                    }
                });

        return view;
    }


    private void setupViewPager(View view)
    {

        viewPager = (WrapContentViewPager) view.findViewById(R.id.pager);
        viewPager.setPagingEnabled(true);

        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tab_layout);

        tabLayout.addTab(tabLayout.newTab().setIcon(ContextCompat.getDrawable(getActivity(), R.drawable.ic_morning)).setText("6 AM - 9 AM"));
        tabLayout.addTab(tabLayout.newTab().setIcon(ContextCompat.getDrawable(getActivity(), R.drawable.ic_afternoon)).setText("9 AM - 12 PM"));
        tabLayout.addTab(tabLayout.newTab().setIcon(ContextCompat.getDrawable(getActivity(), R.drawable.ic_evening)).setText("12 PM - 3 PM"));
        tabLayout.addTab(tabLayout.newTab().setIcon(ContextCompat.getDrawable(getActivity(), R.drawable.ic_moon)).setText("3 PM -  6 PM"));

        final int tabIconColor = ContextCompat.getColor(getActivity(), R.color.black);
        final int tabIconSelectedColor = ContextCompat.getColor(getActivity(), R.color.colorPrimary);


        tabLayout.getTabAt(0).getIcon().setColorFilter(tabIconSelectedColor, PorterDuff.Mode.SRC_IN);
        tabLayout.getTabAt(1).getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
        tabLayout.getTabAt(2).getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
        tabLayout.getTabAt(3).getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final CategoriesAdapter adapter = new CategoriesAdapter(getChildFragmentManager() , tabLayout.getTabCount());

        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                tab.getIcon().setColorFilter(tabIconSelectedColor, PorterDuff.Mode.SRC_IN);

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });



    }


    public void onClick(View view)
    {

        switch (view.getId())
        {
            case R.id.month_txt:

                Calendar now = Calendar.getInstance();
                DatePickerDialog dpd = DatePickerDialog.newInstance(
                        DateTimeFragment.this,
                        now.get(Calendar.YEAR),
                        now.get(Calendar.MONTH),
                        now.get(Calendar.DAY_OF_MONTH)
                );
                dpd.show(getActivity().getFragmentManager(), "Datepickerdialog");


                break;

            case R.id.post_material_button:

                SimpleDateFormat sdf = new SimpleDateFormat("MMMM-dd-yyyy");
                Calendar c = Calendar.getInstance();
                try {
                    c.setTime(sdf.parse(month_txt_disable.getText().toString()));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                c.add(Calendar.DATE, 1);  // number of days to add, can also use Calendar.DAY_OF_MONTH in place of Calendar.DATE
                SimpleDateFormat sdf1 = new SimpleDateFormat("MMMM-dd-yyyy");
                String output = sdf1.format(c.getTime());
                month_txt.setText(output);

                month_txt_disable.setText(output);

        }

    }



    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth)
    {
        Date date2 = new Date();
        SimpleDateFormat date_format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            monthOfYear = monthOfYear + 1;
            date2 = date_format.parse(year + "-" + monthOfYear + "-" + dayOfMonth);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        SimpleDateFormat outDate = new SimpleDateFormat("MMMM-dd-yyyy");
        String n = outDate.format(date2).toString();

        month_txt_disable.setText(n);

        String date_txt = n.substring(0,n.length()-5);

        System.out.println("date============="+date_txt);

        month_txt.setText(date_txt);

      /*   String date = "You picked the following date: "+dayOfMonth+"-"+(++monthOfYear)+"/"+year;
        Date date2 = new Date();
        SimpleDateFormat date_format = new SimpleDateFormat("yyyy-MMMM-dd");
        try
        {
            date2 = date_format.parse(year+"-"+monthOfYear+"-"+dayOfMonth);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }

        System.out.println("date======" + date2.toString());

        String day_txt = date2.toString().substring(0,3);

        String month_data = date2.toString().substring(4, 7);
        month_txt.setText(day_txt + " " + dayOfMonth + " " + month_data);
      */



    }


    @Override
    public void onTimeSet(RadialPickerLayout view, int hourOfDay, int minute, int second) {

        String hourString = hourOfDay < 10 ? "0"+hourOfDay : ""+hourOfDay;
        String minuteString = minute < 10 ? "0"+minute : ""+minute;
        String secondString = second < 10 ? "0"+second : ""+second;
        String time = "You picked the following time: "+hourString+"h"+minuteString+"m"+secondString+"s";
        month_txt.setText(time);
    }

    private void setuptoolbar(View view)
    {

        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);

        toolbar_title_txt = (TextView) getActivity().findViewById(R.id.title_txt);

        toolbar_title_txt.setText("DATE & TIME ");

    }
}

