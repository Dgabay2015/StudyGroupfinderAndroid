package com.example.dalexi1312.studygroupfinder.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dalexi1312.studygroupfinder.R;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class PageFragment extends Fragment {
    //@BindView(R.id.myGroupsTitle) TextView mTitleOfMyGroups;
    TextView mTextViewOfTitle;


    public PageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_page,container,false);

        mTextViewOfTitle = (TextView)view.findViewById(R.id.myGroupsTitle);
        Bundle bundle= getArguments();
        String message = Integer.toString(bundle.getInt("count"));
        mTextViewOfTitle.setText("This is the "+message+"Swipe view of page");
        // Inflate the layout for this fragment
        return view;
    }

}
