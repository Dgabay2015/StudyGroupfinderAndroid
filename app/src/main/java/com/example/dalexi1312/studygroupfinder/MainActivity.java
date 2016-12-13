package com.example.dalexi1312.studygroupfinder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.facebook.FacebookSdk;
import static android.R.color.black;


public class MainActivity extends AppCompatActivity {
    private Button mSignInButton;
    private Button mChooseSignInButton;
    private Button mChooseSignUpButton;
    //making a Group object
    public Group mGroupTest;
    ImageView mTestImageView;



    //this is a comment for testingfghgfngfngf
    //now another comment9090909090908
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSignInButton =(Button) findViewById(R.id.signInButton);
        mChooseSignInButton =(Button) findViewById(R.id.chooseSignInButton);
        mChooseSignUpButton =(Button) findViewById(R.id.signUpButton);



        mSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToClassesView();
            }
        });
        mChooseSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mChooseSignInButton.setTextColor(0xFF002D62);
                mChooseSignUpButton.setTextColor(0xFF000000);

            }
        });
        mChooseSignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mChooseSignUpButton.setTextColor(0xFF002D62);
                mChooseSignInButton.setTextColor(0xFF000000);


            }
        });
        //USING CONSTRUCTOR
        //     public Group(String groupId,String nameOfGroup,String[]members,String meetingTimes,String locationName){
        String[ ] members={"David", "Brandon", "danh","elizabeth","Newil"};
        mTestImageView= (ImageView)findViewById(R.id.testingIconImageView);

        mGroupTest = new Group("TestID","tESTpURPOSESgROUPnAME",members,"5:30pm","EE106");



        //this was a function to add a group but then i added constructor above
       // createTestGroup();
    }
//the function that will generate a test group
    private void createTestGroup() {
        mGroupTest.setGroupId("TestID");//THIS GROUP Id IS TESTID
        //String of members
        String[ ] members={"David", "Brandon", "danh","elizabeth","Newil"};
        mGroupTest.setMembers(members);
        mGroupTest.setLocationName("EE106");
        mGroupTest.setMeetingTimes("5:30pm");
    }

    private void goToClassesView()
    {
        Intent intent = new Intent(this,ClassesViewer.class);

        startActivity(intent);
    }

}
