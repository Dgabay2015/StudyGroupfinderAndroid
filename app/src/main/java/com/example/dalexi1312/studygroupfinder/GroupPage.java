package com.example.dalexi1312.studygroupfinder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class GroupPage extends AppCompatActivity {
    TextView mTextViewForGroupName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_page);
        mTextViewForGroupName=(TextView)findViewById(R.id.groupNameTextView);
        Intent intent = getIntent();
        final String message = intent.getStringExtra(classview.EXTRA_MESSAGE);
        mTextViewForGroupName.setText(message);


    }
}
