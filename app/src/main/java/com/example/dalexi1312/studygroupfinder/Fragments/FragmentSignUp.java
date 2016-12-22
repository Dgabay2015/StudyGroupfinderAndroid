package com.example.dalexi1312.studygroupfinder.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.dalexi1312.studygroupfinder.BlankActivityUsedToDisplayFragments;
import com.example.dalexi1312.studygroupfinder.ClassesViewer;
import com.example.dalexi1312.studygroupfinder.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentSignUp extends Fragment {
    private Button mButton ;


    public FragmentSignUp() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_sign_up, container,         false);
        mButton = (Button)rootView.findViewById(R.id.signUpButton);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(rootView.getContext(),ClassesViewer.class);
                startActivity(intent);
            }
        });



        // Inflate the layout for this fragment

        return rootView;
    }

}
