package com.jbca.fragments;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jbca.Member;
import com.jbca.R;
import com.jbca.adapter.MemberAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MemberFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MemberFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MemberFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private RecyclerView recyclerView;
    private MemberAdapter adapter;
    private List<Member> memberList;

    private OnFragmentInteractionListener mListener;

    public MemberFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MemberFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MemberFragment newInstance(String param1, String param2) {
        MemberFragment fragment = new MemberFragment();
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


    /**
     * Adding few albums for testing
     */
    private void prepareAlbums() {
        int[] covers = new int[]{
                R.drawable.jbca_presdent,
                R.drawable.jbca_vp,
                R.drawable.jbca_secretory,
                R.drawable.jbca_joint_sec,
                R.drawable.jbca_joint_sec_two,
                R.drawable.joint_sec_three,
                R.drawable.joint_sec_four,
                R.drawable.jbca_treasurer,
                R.drawable.jbca_treasurer_two,
                R.drawable.jbca_comitee_member,
                R.drawable.jbca_committee_member,
                R.drawable.jbca_advisory_one,
                R.drawable.jbca_advisory_two,
                R.drawable.jbca_advisory_three,
                R.drawable.jbca_advisory_four};

        Member a = new Member(getResources().getString(R.string.president), "Shubhas Chandra Roy", covers[0],"+919538796070");
        memberList.add(a);

        a = new Member(getResources().getString(R.string.vp), "Suteertha Mitra", covers[1],"+919880003376");
        memberList.add(a);

        a = new Member(getResources().getString(R.string.secretory), "Swadesh Ranjan Das", covers[2],"+919731988441");
        memberList.add(a);

        a = new Member(getResources().getString(R.string.joint_sec), "Sanjay Mitra", covers[3],"+919916122770");
        memberList.add(a);

        a = new Member(getResources().getString(R.string.joint_sec), "Dwaipayan Ghosh", covers[4],"+919448710129");
        memberList.add(a);

        a = new Member(getResources().getString(R.string.joint_sec), "Subhabrata Pal", covers[5],"+919886198204");
        memberList.add(a);

        a = new Member(getResources().getString(R.string.joint_sec), "Lovely Mitra", covers[6],"+919886540229");
        memberList.add(a);

        a = new Member(getResources().getString(R.string.tresurer), "Partho Basu", covers[7],"+919379101400");
        memberList.add(a);

        a = new Member(getResources().getString(R.string.tresurer), "Saurav Chatterjee", covers[8],"+919886503748");
        memberList.add(a);

        a = new Member(getResources().getString(R.string.committee), "Sumit Roy", covers[9],"+919731619578");
        memberList.add(a);

        a = new Member(getResources().getString(R.string.committee), "Nupur Kabiraj", covers[10],"+919845029710");
        memberList.add(a);

        a = new Member(getResources().getString(R.string.advisory), "Prabir Kumar Dey", covers[11],"+919480452556");
        memberList.add(a);

        a = new Member(getResources().getString(R.string.advisory), "Saugata Banerjee", covers[12],"+919900907436");
        memberList.add(a);

        a = new Member(getResources().getString(R.string.advisory), "Souren Mitra", covers[13],"+919916170609");
        memberList.add(a);

        a = new Member(getResources().getString(R.string.advisory), "Pramod Das", covers[14],"+918197201029");
        memberList.add(a);

        adapter.notifyDataSetChanged();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_members, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

        memberList = new ArrayList<>();
        adapter = new MemberAdapter(getActivity(), memberList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        prepareAlbums();
        return view;
    }

    /**
     * RecyclerView item decoration - give equal margin around grid item
     */
    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
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
