package com.example.dalexi1312.studygroupfinder.adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.dalexi1312.studygroupfinder.Fragments.ClassResultsFragment;
import com.example.dalexi1312.studygroupfinder.Fragments.FragmentSignUp;
import com.example.dalexi1312.studygroupfinder.Fragments.PageFragment;
import com.example.dalexi1312.studygroupfinder.Fragments.ProfileFragment;

public class SwipeAdapter extends FragmentStatePagerAdapter {

    public SwipeAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
      ClassResultsFragment f1 = new ClassResultsFragment();
       // BlankFragment f1 = new BlankFragment();
        FragmentSignUp f2 = new FragmentSignUp();
        ProfileFragment fragment = new ProfileFragment();
        Fragment[] fragmentArray = {f1,f2,fragment};



        Bundle bundle = new Bundle();
        bundle.putInt("count",position+1);
        fragment.setArguments(bundle);
        return fragmentArray[position];

    }

    @Override
    public int getCount() {
        return 3;
    }
}
