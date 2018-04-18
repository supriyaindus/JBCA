package com.jbca.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jbca.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ContactFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ContactFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private String member = "<u>Not A Memeber Yet??</u>";
    private String contact_info = "We welcome one and all to be a part of our family. If you are interested, then please feel free to contact us on any of the numbers below and we will help you to take the relationship forward.\n" +
            "\u200BIf you are interested in becoming a sponsor  partner of JBCA– Durga Puja 2017, please contact us @ :\n\n" +
            "<b>Call   or WhatsApp:    91-9008804502</b>     \n" +
            "<b>Email:  marketing@jbca.co.in</b>\n\n\n" +
            "All payments are mandatory to be paid in full, a week before the commencement of the Puja and is non-refundable. The cheque / DD will be made in favor of ‘JAGRITI BANGIYO CULTURAL ASSOCIATION’. We also welcome NEFT transfer of payment.Our bank details are as below\n\n" +
            "<b>Bank Name: Andhra Bank</b>\n" +
            "<b>Branch: Ramamurthy Nagar</b>\n" +
            "<b>Account Number:  162710100107647</b>\n" +
            "<b>IFSC code:  ANDB0001627</b>\n" +
            "<b>MICR Code:  560011034</b>";


    public ContactFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ContactFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ContactFragment newInstance(String param1, String param2) {
        ContactFragment fragment = new ContactFragment();
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
        View view = inflater.inflate(R.layout.fragment_contact, container, false);
        ((TextView)view.findViewById(R.id.txt_contact_info)).setText(Html.fromHtml(contact_info.replace("\n", "<br>")));
        ((TextView)view.findViewById(R.id.txt_membership_info)).setText(Html.fromHtml(member.replace("\n", "<br>")));
        return view;
    }

}
