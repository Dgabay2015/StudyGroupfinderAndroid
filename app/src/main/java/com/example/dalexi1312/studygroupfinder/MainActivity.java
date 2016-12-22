package com.example.dalexi1312.studygroupfinder;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dalexi1312.studygroupfinder.Fragments.AlertDialogFragment;
import com.example.dalexi1312.studygroupfinder.Fragments.FragmentSignIn;
import com.example.dalexi1312.studygroupfinder.Fragments.FragmentSignUp;

import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    public static final String TAG=MainActivity.class.getSimpleName();
    //@BindView (R.id.usernameEditText) EditText mSignInEditText;
    //button that proceeeds to next page once clicked
    //@BindView(R.id.signInButton) Button mSignInButton;
    @BindView(R.id.chooseSignInButton) Button mChooseSignInButton;
    @BindView(R.id.chooseSignUpButton) Button mChooseSignUpButton;
    //should display amount of groups in particular school
    @BindView(R.id.amountOfGroupsTextView) TextView mAmountOfGroups;
    public String  userName;
    public final static String EXTRA_USER = "EXTRA USER";

    //making a Group object
    public Group mGroupTest;
    ImageView mTestImageView;
    private Group mGroupFromWeb;
    public String groupID;//THIS WILL be the groups id# used to do various things and will be pasted into URL

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //going to make test situation if user types david then the group id automatically becomes 584f6133ee1e7e0ce16def3c which is study group 1

            groupID = "584f6133ee1e7e0ce16def3c";
        //okhttp content

        String GroupUrl = "https://sgf-api.herokuapp.com/groups/"+groupID;
        //error handling for network connectivity

        if(isNetworkAvailable()) {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(GroupUrl)
                    .build();
            Call call = client.newCall(request);
            call.enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {

                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    //asynchronus web get
                    try {
                        String jsonData = response.body().string();
                        Log.v(TAG, jsonData);
                        if (response.isSuccessful()) {
                            mGroupFromWeb = getGroupDetails(jsonData);


                        } else {
                            alertUserAboutError();
                        }
                    }
                    catch (IOException e) {
                        Log.e(TAG, "Exception caught: ", e);
                    }
                    catch (JSONException e)
                    {
                        Log.e(TAG, "Exception caught: ", e);
                    }

                }
            });

        }
        else{
            Toast.makeText(this,"Network is unavailable",Toast.LENGTH_LONG)
                    .show();
        }

/*        mSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                goToClassesView();
            }
        });*/
        // the code below is responsible for changing the color of the text when you switch from sign in to sign up

        //implementing username/sign up frag
        FragmentSignIn f2 = new FragmentSignIn();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragmentContainer, f2);
        //fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
        mChooseSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentSignIn f2 = new FragmentSignIn();
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentContainer, f2);
                //fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                mChooseSignInButton.setTextColor(0xFF002D62);
                mChooseSignUpButton.setTextColor(0xFF000000);
            }
        });
        mChooseSignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentSignUp f1 = new FragmentSignUp();
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentContainer,f1);
                // fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                mChooseSignUpButton.setTextColor(0xFF002D62);
                mChooseSignInButton.setTextColor(0xFF000000);
            }
        });

        //USING CONSTRUCTOR
        //     public Group(String groupId,String nameOfGroup,String[]members,String meetingTimes,String locationName){
        String[ ] members={"David", "Brandon", "danh","elizabeth","Newil"};
        mTestImageView= (ImageView)findViewById(R.id.testingIconImageView);
        mGroupTest = new Group("TestID","tESTpURPOSESgROUPnAME",members,"5:30pm","EE106","CEN4010");

        //this was a function to add a group but then i added constructor above
       // createTestGroup();


    }

    private Group getGroupDetails(String jsonData) throws JSONException {
        Group newGroup = new Group();
        JSONObject groupfromJson = new JSONObject(jsonData);

        String groupId= groupfromJson.getString("name");
        String groupMembers = groupfromJson.getString("members");
        newGroup.setNameOfGroup(groupId);
        Log.i(TAG,"From JSON: "+ groupId);
        Log.i(TAG,"From JSON: "+ groupMembers);
        // Toast.makeText(this,groupId,Toast.LENGTH_LONG);
        return newGroup;

    }

    private boolean isNetworkAvailable() {
        ConnectivityManager manager = (ConnectivityManager) getSystemService
                (Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        boolean isAvailable =false;
        if(networkInfo != null && networkInfo.isConnected()){
            isAvailable = true;
        }

return isAvailable;
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

/*    private void goToClassesView()
    {
        Intent intent = new Intent(this,ClassesViewer.class);
        intent.putExtra(EXTRA_USER,userName);

        startActivity(intent);
    }*/
    private void alertUserAboutError(){
        AlertDialogFragment dialog =new AlertDialogFragment();
        dialog.show(getFragmentManager(),"error_dialog");
    }

}
