package com.example.dalexi1312.studygroupfinder;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.dalexi1312.studygroupfinder.adapters.ListAdapter;

public class classview extends AppCompatActivity {
    private FloatingActionButton maddGroup;
    private TextView mTextViewClassName;
    private ListView mListViewOfGroupsAvailable; //will be the list og groups you can be a part of based on yor class selection
    public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    public final static String EXTRA_GROUP = "EXTRA GROUP";
    public final static String EXTRA_POS = "EXTRA POS";

    public int groupPicked;
    public String groupNamemessage;

    //dummy variable for now


    //ARRAY OF groups i will create
    String[ ] members={"David", "Brandon", "danh","elizabeth","Newil"};
    String[ ] members2={"David", "Brandon", "danh","elizabeth","Newil","keith"};
    String[ ] members3={"David", "Brandon", "danh","elizabeth","Newil","john","felesha"};
    String[ ] members4={"David", "Brandon", "danh","elizabeth","Newil","tom","vein","Paul","forker","spoon","walker"};

    Group mGroupTest=new Group("TestID1","WE study HARD",members,"5:30pm","EE106");
    Group mGroupTest1=new Group("TestID2","Outside studiers",members2,"5:30pm","EE106");
    Group mGroupTest2=new Group("TestID3","Computer Scientist",members4,"5:30pm","EE107");
    Group mGroupTest3=new Group("TestID4","Dr. Huang",members3,"5:30pm","EE108");
    Group mGroupTest4=new Group("TestID5","Juniors Study",members,"5:30pm","EE109");
    Group mGroupTest5=new Group("TestID6","MostValuableStudy",members3,"5:30pm","EE100");

    private Group[] mGroups = {
            mGroupTest,mGroupTest1,mGroupTest2,mGroupTest3,mGroupTest4,mGroupTest5
    };





    String[ ] groups={"Computer Scientists @ FAU", "cool bean study","MathGuys","WE STUDY 4FUN","Outdoor FAU Studiers","Dr. Huang Help Group ","MID-FINAL'S ONLY @ FAU"};// dummy array serving as groups that are study groups for class selected

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classview);
        mListViewOfGroupsAvailable = (ListView)findViewById(R.id.groupsAvailableListView);

        /*ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,groups);
        mListViewOfGroupsAvailable.setAdapter(adapter);
*/
        ListAdapter adapter = new ListAdapter(this,mGroups);
        mListViewOfGroupsAvailable.setAdapter(adapter);



        mTextViewClassName = (TextView)findViewById(R.id.showClassNameTextView ) ;
        Intent intent = getIntent();
        final String message = "Results for class :\n" + intent.getStringExtra(ClassesViewer.EXTRA_MESSAGE);
        mTextViewClassName.setText(message);
        mListViewOfGroupsAvailable.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               groupNamemessage = parent.getItemAtPosition(position)+ " ";
                groupPicked=position;

                goToGroupPage();
            }
        });




        maddGroup=(FloatingActionButton)findViewById(R.id.floatingActionButtonAddGroup);
        maddGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goAddGroupView();
            }
        });

    }

    private void goToGroupPage() {
        Intent intent = new Intent(this, GroupPage.class);
        intent.putExtra(EXTRA_MESSAGE,groupNamemessage);
        intent.putExtra(EXTRA_GROUP,mGroups);//this passes my array of Group objects
        intent.putExtra(EXTRA_POS,groupPicked);//this passes position

        startActivity(intent);
    }

    private void goAddGroupView() {
        Intent intent = new Intent(this, AddGroup.class);
        startActivity(intent);
    }
}

