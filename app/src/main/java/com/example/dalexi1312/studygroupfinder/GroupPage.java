package com.example.dalexi1312.studygroupfinder;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;

public class GroupPage extends AppCompatActivity {
    TextView mTextViewForGroupName;
    TextView mMeetupLocationTextView;
    private Group[] mGroups;



    ImageView mTestImageView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_page);
        mTestImageView= (ImageView)findViewById(R.id.testingIconImageView);
        mMeetupLocationTextView=(TextView)findViewById(R.id.meetUpLocationtextView);


       // createTestGroup();
        mTextViewForGroupName=(TextView)findViewById(R.id.groupNameTextView);
        Intent intent = getIntent();
        final String message = intent.getStringExtra(classview.EXTRA_MESSAGE);

        final int groupPositionInArray = intent.getIntExtra(classview.EXTRA_POS,0);
        Parcelable[ ] parcelables = intent.getParcelableArrayExtra(classview.EXTRA_GROUP);
       mGroups = Arrays.copyOf(parcelables, parcelables.length,Group[].class);
        mMeetupLocationTextView.setText(mGroups[groupPositionInArray].getNameOfGroup());
        //to test if group object works i will put the name of test group in the group page header
       // mTextViewForGroupName.setText(mGroupTest.getNameOfGroup());//used to be message as param


    }
}
