package com.jbca.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jbca.R;
import com.jbca.adapter.HomePagerAdapter;

import java.util.Timer;
import java.util.TimerTask;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HomeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private String info = "Greetings from Jagriti Bangiyo Cultural Association (JBCA)! Jagriti Bangiyo Cultural Association is pleased to announce the celebration of Durga Puja “Sharad Utsav - 2017” between 26th September – 30th September at the ITI (Indian Telephone Industries) Hockey Ground near K.R. Puram hanging bridge.\n" +
            "\u200Bআহা কি আনান্দ , ডাকছে আকাশ ,ফিরিয়ে দাও ,ফিরে চল্, ফিরে চল্, অরণ্য চাই, ও আকাশ সোনা সোনা , আয়ে রে মোরা ফশল কাটি  সবুজ পাহাড় ডাকে ,শপ্তফূল বিকশিত হক ,এক দিন ঝড় থেমে যাবে, আয়ে কে যাবি আয়ে\n" +
            "We at JBCA, committed to maintain clean, green environment and conserve our natural resources for better future. Our Durga Puja 2017 theme is 'Go Green', which we have chosen  to serve for greater cause of our Society.\n" +
            "\u200Bজাগৃতি বঙ্গীয় কালচারাল এসোসিয়েশন এর পক্ষ্যে থেকে সবাই কে জানাই শারদীয়া প্রীতি ও শুভেচ্ছা, মা দূর্গা সবার জীবনে নিয়ে আসুক সুখ ও শান্তি";
    private String schedule = "<u>মহা পঞ্চমী সোমবার  25 Sep</u>\n" +
            "\u200Bবোধন 6:30PM\n\n<u>মহা ষষ্ঠী মঙ্গলবার  26 Sep</u>\n" +
            "ষষ্ঠীপূজা 9:00 AM, \n" +
            "অজ্ঞলী 10:30 AM,\n" +
            "আমন্ত্রন ও অধিবাস 6:30 PM\n\n<u>মহা সপ্তমী  বুধবার  27 Sep</u>\n" +
            "\u200Bসপ্তমীপূজা 6:30AM\n" +
            "অজ্ঞলী 10:30AM,\n" +
            "ভোগ 12:00PM, \n" +
            "সন্ধাআরতি 6:30PM\n\n<u>মহা অষ্টমী বৃহস্পতিবার  28 Sep</u>\n" +
            "অষ্টমীপূজা 6:00AM,\n" +
            "অজ্ঞলী 10:30AM,\n" +
            "ভোগ 12:00PM, \n" +
            "সন্ধিপূজা 7:06PM-7:54PM, \n" +
            "সন্ধাআরতি 8:00PM\n\n<u>মহা নবমী শুক্রবার  29 Sep</u>\n" +
            "নবমীপূজা 6:00AM, \n" +
            "অজ্ঞলী 10:30AM,\n" +
            "ভোগ 12:00Noon,\n" +
            "হোম 2:00PM, \n" +
            "সন্ধাআরতি 6:30PM\n\n<u>মহা দশমী  শনিবার  26 Sep</u>\n" +
            "দশমীপূজা 7:00AM, \n" +
            "অজ্ঞলী 8:00AM\n" +
            "সিন্দুর খেলা 9:00AM,\n" +
            "বিসর্জন 12:00PM, \n" +
            "শান্তিরজল 5:00PM";

    private OnFragmentInteractionListener mListener;

    int currentPage = 0;
    Timer timer;
    final long DELAY_MS = 700;//delay in milliseconds before task is to be executed
    final long PERIOD_MS = 2000; // time in milliseconds between successive task executions.



    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        final ViewPager viewPager = (ViewPager) view.findViewById(R.id.view_pager);
        ((TextView)view.findViewById(R.id.txt_info)).setText(info);
        ((TextView)view.findViewById(R.id.txt_schedule)).setText(Html.fromHtml(schedule.replace("\n", "<br>")));
        viewPager.setAdapter(new HomePagerAdapter(getContext()));
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == 4) {
                    currentPage = 0;
                }
                viewPager.setCurrentItem(currentPage++, true);
            }
        };

        viewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN :
                        timer.cancel();
                        timer.purge();
                }
                return false;
            }
        });

        if(timer == null) {
            timer = new Timer(); // This will create a new Thread
            timer.schedule(new TimerTask() { // task to be scheduled

                @Override
                public void run() {
                    handler.post(Update);
                }
            }, DELAY_MS, PERIOD_MS);
        }
        return view;
    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
    }


    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
