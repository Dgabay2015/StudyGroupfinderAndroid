package com.example.dalexi1312.studygroupfinder;

import android.content.Intent;
import android.media.Image;
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
    private ImageView mgroupIconImageView;
    private TextView mGroupMembersTextView;
    private TextView mMeetUpTimeTextView;

    private String members;




    ImageView mTestImageView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_page);
        mTestImageView= (ImageView)findViewById(R.id.testingIconImageView);//declaring all views in activity
        mMeetupLocationTextView=(TextView)findViewById(R.id.meetUpSpotTextView);
        mgroupIconImageView = (ImageView)findViewById(R.id.GroupIconImageView) ;
        mGroupMembersTextView= (TextView ) findViewById(R.id.groupmemberslhereTextView);
        mMeetUpTimeTextView = (TextView)findViewById(R.id.meetUpTimeTextView);



       // createTestGroup();
        mTextViewForGroupName=(TextView)findViewById(R.id.groupNameTextView);
        Intent intent = getIntent();
        final String message = intent.getStringExtra(classview.EXTRA_MESSAGE);


        final int groupPositionInArray = intent.getIntExtra(classview.EXTRA_POS,0);
        Parcelable[ ] parcelables = intent.getParcelableArrayExtra(classview.EXTRA_GROUP);
       mGroups = Arrays.copyOf(parcelables, parcelables.length,Group[].class);
        mMeetupLocationTextView.setText(mGroups[groupPositionInArray].getLocationName());
        //to test if group object works i will put the name of test group in the group page header
        mTextViewForGroupName.setText(mGroups[groupPositionInArray].getNameOfGroup());//used to be message as param
        mMeetUpTimeTextView.setText(mGroups[groupPositionInArray].getMeetingTimes());
        members ="";//was displaying "null "at begining of members list so i added blank string "thug life"

        for(int i=0;i<mGroups[groupPositionInArray].getMembers().length;i++) {
            members += mGroups[groupPositionInArray].getMembers()[i] +", ";
        }

        mGroupMembersTextView.setText(members);
        //should set group icon here
      // mgroupIconImageView.setImageResource(getDrawable(mGroups[groupPositionInArray].getGravatar()));
        mgroupIconImageView.setImageResource(R.drawable.slackgrav1);


    }
}
