package com.example.dalexi1312.studygroupfinder;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.dalexi1312.studygroupfinder.adapters.MyGroupsFragment;
import com.example.dalexi1312.studygroupfinder.adapters.SwipeAdapter;

public class BlankActivityUsedToDisplayFragments extends AppCompatActivity {
    ViewPager mViewPager;
    public TabLayout mTabLayout ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blank_used_to_display_fragments);

        mViewPager = (ViewPager)findViewById(R.id.view_pager);
        SwipeAdapter swipeAdapter = new SwipeAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(swipeAdapter);
        Intent intent = getIntent();
        final int posOfGroup = intent.getIntExtra(GroupPage.EXTRA_POS,0);


        mTabLayout = (TabLayout)findViewById(R.id.tabLayout);
        mTabLayout.setupWithViewPager(mViewPager,true);
    }
}
