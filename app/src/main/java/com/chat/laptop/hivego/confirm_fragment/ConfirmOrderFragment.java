package com.chat.laptop.hivego.confirm_fragment;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.transition.Visibility;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chat.laptop.hivego.R;
import com.chat.laptop.hivego.payment.PaymentFragment;
import com.chat.laptop.hivego.salon.salon_detail_list.SalonDetailsFragment;
import com.chat.laptop.hivego.services.MenServicesAdapter;
import com.chat.laptop.hivego.services.MenServicesData;

import java.util.ArrayList;


public class ConfirmOrderFragment extends Fragment implements View.OnClickListener
{

    Button applyButton,earlyBirdButton,payButton;
    TextView toolbar_title_txt,discount_rupees,total_payable_rupees,discount_rupees_symbol,total_payable_rupees_symbol;
    LinearLayout linearlayout;
    EditText editText;
    RecyclerView confirm_recyclerview;
    ConfirmOrderAdapter confirmServicesAdapter;
    public static ArrayList<ConfirmOrderData> confirmOrderDatas = new ArrayList<>();


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_confirm_order, container, false);

        setuptoolbar(view);
        setServicesData();
        setupLayout(view);
        setup_recyclerview(view);
        setup_font(view);

        return view;
    }

    private void setupLayout(View view)
    {
        payButton = (Button) view.findViewById(R.id.payButton);
        payButton.setOnClickListener(this);

        applyButton = (Button) view.findViewById(R.id.applyButton);
        applyButton.setOnClickListener(this);

        earlyBirdButton = (Button) view.findViewById(R.id.earlyBirdButton);
        earlyBirdButton.setOnClickListener(this);

        linearlayout = (LinearLayout) view.findViewById(R.id.enterCodelayout);

        editText = (EditText) view.findViewById(R.id.discountEdittext);

        discount_rupees = (TextView) view.findViewById(R.id.discount_rupees);

        discount_rupees_symbol = (TextView) view.findViewById(R.id.discount_rupees_symbol);

        total_payable_rupees = (TextView)  view.findViewById(R.id.total_payable_rupees);

        total_payable_rupees_symbol = (TextView) view.findViewById(R.id.total_payable_rupees_symbol);

    }

    private void setup_recyclerview(View view)
    {
        confirm_recyclerview = (RecyclerView) view.findViewById(R.id.recyclerView);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        confirm_recyclerview.setLayoutManager(mLayoutManager);

        confirmServicesAdapter = new ConfirmOrderAdapter(getActivity(), confirmOrderDatas);

        confirm_recyclerview.setAdapter(confirmServicesAdapter);

        confirm_recyclerview.setNestedScrollingEnabled(true);
    }


    private void setServicesData()
    {
        try
        {
            confirmOrderDatas.clear();
        }
        catch (Exception ex) {
        }
        confirmOrderDatas.add(new ConfirmOrderData("Crystal Spa Manicure","","600"));
        confirmOrderDatas.add(new ConfirmOrderData("Crystal Spa Manicure", "", "1200"));
        confirmOrderDatas.add(new ConfirmOrderData("Crystal Spa Manicure", "", "600"));

    }

    private void setuptoolbar(View view)
    {
        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);

        toolbar_title_txt = (TextView) getActivity().findViewById(R.id.title_txt);

        toolbar_title_txt.setText("CONFIRM");

    }

    private void setup_font(View view)
    {

        Typeface tf = Typeface.createFromAsset(getActivity().getAssets(), "Lato-Regular.ttf");
        toolbar_title_txt.setTypeface(tf);
    }


    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.applyButton:

                applyButton.setVisibility(View.GONE);
                editText.setVisibility(View.GONE);
                earlyBirdButton.setVisibility(View.VISIBLE);
                discount_rupees.setTextColor(getResources().getColor(R.color.green));
                total_payable_rupees.setTextColor(getResources().getColor(R.color.green));
                total_payable_rupees_symbol.setTextColor(getResources().getColor(R.color.green));
                discount_rupees_symbol.setTextColor(getResources().getColor(R.color.green));

                break;

            case R.id.earlyBirdButton:

                earlyBirdButton.setVisibility(View.GONE);
                editText.setVisibility(View.VISIBLE);
                applyButton.setVisibility(View.VISIBLE);


                break;
            case R.id.payButton:

                PaymentFragment salonListFragment = new PaymentFragment();
                FragmentManager fragmentManager = ((AppCompatActivity)getActivity()).getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction search_fragmentTransaction = fragmentManager.beginTransaction();
                search_fragmentTransaction.replace(R.id.frame, salonListFragment);
                search_fragmentTransaction.addToBackStack(null);
                search_fragmentTransaction.commit();

        }
    }
}
