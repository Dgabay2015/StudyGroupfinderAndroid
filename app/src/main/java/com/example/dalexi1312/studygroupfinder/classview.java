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

public class classview extends AppCompatActivity {
    private FloatingActionButton maddGroup;
    private TextView mTextViewClassName;
    private ListView mListViewOfGroupsAvailable; //will be the list og groups you can be a part of based on yor class selection
    public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    public String groupNamemessage;


    String[ ] groups={"Computer Scientists @ FAU", "cool bean study","MathGuys","WE STUDY 4FUN","Outdoor FAU Studiers","Dr. Huang Help Group ","MID-FINAL'S ONLY @ FAU"};// dummy array serving as groups that are study groups for class selected

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classview);
        mListViewOfGroupsAvailable = (ListView)findViewById(R.id.groupsAvailableListView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,groups);
        mListViewOfGroupsAvailable.setAdapter(adapter);




        mTextViewClassName = (TextView)findViewById(R.id.showClassNameTextView ) ;
        Intent intent = getIntent();
        final String message = "Results for class :\n" + intent.getStringExtra(ClassesViewer.EXTRA_MESSAGE);
        mTextViewClassName.setText(message);
        mListViewOfGroupsAvailable.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               groupNamemessage = parent.getItemAtPosition(position)+ " ";
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
        startActivity(intent);
    }

    private void goAddGroupView() {
        Intent intent = new Intent(this, AddGroup.class);
        startActivity(intent);
    }
}

