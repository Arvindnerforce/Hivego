package com.chat.laptop.hivego.dashboard.navigation;


import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.chat.laptop.hivego.R;
import com.chat.laptop.hivego.appointments.my_appointment.MyAppointmentFragment;
import com.chat.laptop.hivego.blog.BlogFragment;
import com.chat.laptop.hivego.chat.ChatWithusFragment;
import com.chat.laptop.hivego.dashboard.fragment.GenderFragment;
import com.chat.laptop.hivego.edit_profile.EditProfileFragment;
import com.chat.laptop.hivego.invite_friends.InviteFriendsFragment;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class NavigationFragment extends Fragment implements RecyclerAdapterDrawer.clickListner, View.OnClickListener
{

    public static final String preFile = "textFile";
    public static final String userKey = "key";
    private static final String TAG = "gcm_tag";
    private static int POSITION = 0;
    public static ActionBarDrawerToggle mDrawerToggle;
    public static DrawerLayout mDrawerLayout;
    boolean mUserLearnedDrawer;
    boolean mFromSavedInstance;
    View view;
    RecyclerView recyclerView;
    public static RecyclerAdapterDrawer adapter;
    public static final String PREFS_NAME = "call_recorder";
    private SharedPreferences loginPreferences;
    public static SharedPreferences.Editor loginPrefsEditor;
    public static List<RowDataDrawer> list = new LinkedList<>();
    private Context context;
    ImageButton close_Button;
    RelativeLayout header;
    CircleImageView circleImageViewProfilePic;
    TextView textViewName;
    private GenderFragment genderFragment;



    public NavigationFragment()
    {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_navigation, container, false);
        initView();
        return view;
    }

    private void initView()
    {
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler);

        close_Button = (ImageButton) view.findViewById(R.id.close_Button);

        close_Button.setOnClickListener(this);

        list = setDrawer();

        header = (RelativeLayout) view.findViewById(R.id.header);

        adapter = new RecyclerAdapterDrawer(context, list);

        adapter.setClickListner(this);

        header.setOnClickListener(this);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        recyclerView.setNestedScrollingEnabled(true);

    }



    private List<RowDataDrawer> setDrawer()
    {
        List<RowDataDrawer> list = new ArrayList<>();

        String title[] = {"USER PROFILE","BOOK APPOINTMENT","MANAGE APPOINTMENT", "ARTICLES", "INVITE FRIENDS", "CHAT WITH US","FEEDBACK","ABOUT HIVEGO","BLOG"};

        int drawableId[];

        for (int i = 0; i < title.length; i++)
        {
            RowDataDrawer current = new RowDataDrawer();
            current.text = title[i];
            list.add(current);
        }

        Log.i("TAG count", list.size() + "");
        return list;
    }


    public static void openDrawer()
    {

    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        context = getActivity();
        mUserLearnedDrawer = Boolean.valueOf(readFromPreferences(getActivity(), userKey, "false"));
        if (savedInstanceState != null) {
            mFromSavedInstance = true;
        }
    }

    public void setup(int id, final DrawerLayout drawer, Toolbar toolbar)
    {
        view = getActivity().findViewById(id);

        mDrawerLayout = drawer;
        mDrawerToggle = new ActionBarDrawerToggle(getActivity(), drawer, toolbar, R.string.drawer_open, R
                .string.drawer_close)
        {
            @Override
            public void onDrawerOpened(View drawerView)
            {
                hideSoftKeyboard(getActivity());

                super.onDrawerOpened(drawerView);
                if (!mUserLearnedDrawer)
                {
                    mUserLearnedDrawer = true;
                    savedInstances(getActivity(), userKey, mUserLearnedDrawer + "");
                }
                getActivity().invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView)
            {
                super.onDrawerClosed(drawerView);
                getActivity().invalidateOptionsMenu();

            }

        };

        mDrawerLayout.addDrawerListener(mDrawerToggle);
        mDrawerLayout.post(new Runnable() {
            @Override
            public void run() {
                mDrawerToggle.syncState();
            }
        });


    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        mDrawerLayout.closeDrawers();

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    public static void savedInstances(Context context, String preferenceName, String preferenceValue)
    {
        SharedPreferences sharePreference = context.getSharedPreferences(preFile, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharePreference.edit();
        editor.putString(preferenceName, preferenceValue);
        editor.apply();
    }

    public static String readFromPreferences(Context context, String preferenceName, String defaultValue)
    {
        SharedPreferences sharePreference = context.getSharedPreferences(preFile, Context.MODE_PRIVATE);
        return sharePreference.getString(preferenceName, defaultValue);
    }

    @Override
    public void itemClicked(View view, int position) {
        try
        {

            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            RecyclerAdapterDrawer.selected_item = position;
            adapter.notifyDataSetChanged();
            mDrawerLayout.closeDrawers();
            switch (RecyclerAdapterDrawer.selected_item)
            {
                case 0:

                    EditProfileFragment editProfileFragment = new EditProfileFragment();
                    android.support.v4.app.FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.frame, editProfileFragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                    break;

                case 1:

                    MyAppointmentFragment myAppointmentFragment = new MyAppointmentFragment();
                    FragmentTransaction myspitFragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                    myspitFragmentTransaction.replace(R.id.frame,myAppointmentFragment);
                    myspitFragmentTransaction.addToBackStack(null);
                    myspitFragmentTransaction.commit();


                    break;


                case 2:

                    GenderFragment genderFragment = new GenderFragment();
                    FragmentTransaction editfragmentTrasaction = getActivity().getSupportFragmentManager().beginTransaction();
                    editfragmentTrasaction.replace(R.id.frame,genderFragment);
                    editfragmentTrasaction.addToBackStack(null);
                    editfragmentTrasaction.commit();


                    break;

                case 3:

                    GenderFragment contactlistFragment = new GenderFragment();
                    android.support.v4.app.FragmentTransaction fragmentTransaction2 = getActivity().getSupportFragmentManager().beginTransaction();
                    fragmentTransaction2.replace(R.id.frame, contactlistFragment);
                    fragmentTransaction2.addToBackStack(null);
                    fragmentTransaction2.commit();
                    //Intent i2 = new Intent(getActivity(), PostTripActivity.class);
                    //startActivity(i2);
                    // setupSpecial_Category(0);
                    break;
                case 4:

                    InviteFriendsFragment inviteFriendsFragment = new InviteFriendsFragment();
                    android.support.v4.app.FragmentTransaction searchfragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                    searchfragmentTransaction.replace(R.id.frame, inviteFriendsFragment);
                    searchfragmentTransaction.addToBackStack(null);
                    searchfragmentTransaction.commit();

                    break;
                case 5:

                    ChatWithusFragment chatWithusFragment = new ChatWithusFragment();
                    android.support.v4.app.FragmentTransaction post_fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                    post_fragmentTransaction.replace(R.id.frame, chatWithusFragment);
                    post_fragmentTransaction.addToBackStack(null);
                    post_fragmentTransaction.commit();

                    break;
                case 6:

                    GenderFragment messageFragment = new GenderFragment();
                    android.support.v4.app.FragmentTransaction message_fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                    message_fragmentTransaction.replace(R.id.frame, messageFragment);
                    message_fragmentTransaction.addToBackStack(null);
                    message_fragmentTransaction.commit();


                    break;
                case 7:



                    break;

                case 8:

                    BlogFragment blogFragment = new BlogFragment();
                    android.support.v4.app.FragmentTransaction blog_fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                    blog_fragmentTransaction.replace(R.id.frame, blogFragment);
                    blog_fragmentTransaction.addToBackStack(null);
                    blog_fragmentTransaction.commit();

                    break;

            }

        } catch (Exception e) {

        }


    }

    public static void hideSoftKeyboard(Activity activity)

    {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);

    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {

            case R.id.header:
                showMessage("header");
                break;

            case R.id.close_Button:

                break;
        }
    }

    private void showMessage(String clicked) {
        Toast.makeText(context, clicked, Toast.LENGTH_SHORT).show();
    }




}