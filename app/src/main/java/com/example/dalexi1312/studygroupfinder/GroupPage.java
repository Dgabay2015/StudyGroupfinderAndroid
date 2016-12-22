package com.example.dalexi1312.studygroupfinder;

import android.content.Intent;
import android.os.Parcelable;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dalexi1312.studygroupfinder.Fragments.PageFragment;

import org.w3c.dom.Text;

import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GroupPage extends AppCompatActivity {
    private Group[] mGroups;
    @BindView(R.id.joinGroupButton) Button mJoinGroupButton;
    //@BindView(R.id.testingIconImageView) ImageView mTestImageView;
    @BindView(R.id.meetUpTimeTextView) TextView mMeetUpTimeTextView;
    @BindView(R.id.meetUpSpotTextView ) TextView mMeetupLocationTextView;
    @BindView(R.id.GroupIconImageView) ImageView mgroupIconImageView;
    @BindView(R.id.groupmemberslhereTextView) TextView mGroupMembersTextView;
    @BindView(R.id.groupNameTextView) TextView mTextViewForGroupName;

    private String members;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_page);
        ButterKnife.bind(this);

       // createTestGroup();
        Intent intent = getIntent();
        final String message = intent.getStringExtra(Classview.EXTRA_MESSAGE);


        final int groupPositionInArray = intent.getIntExtra(Classview.EXTRA_POS,0);
        Parcelable[ ] parcelables = intent.getParcelableArrayExtra(Classview.EXTRA_GROUP);
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
        mJoinGroupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToBrowseAndBeginTab();
            }
        });


    }
    private void goToBrowseAndBeginTab()
    {
        Intent intent = new Intent(this,BlankActivityUsedToDisplayFragments.class);
        //intent.putExtra(EXTRA_USER,userName);

        startActivity(intent);
    }
}
