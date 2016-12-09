package com.example.dalexi1312.studygroupfinder;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class classview extends AppCompatActivity {
    private FloatingActionButton maddGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classview);
        maddGroup=(FloatingActionButton)findViewById(R.id.floatingActionButtonAddGroup);
        maddGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goAddGroupView();
            }
        });

    }
    private void goAddGroupView() {
        Intent intent = new Intent(this, AddGroup.class);
        startActivity(intent);
    }
}

