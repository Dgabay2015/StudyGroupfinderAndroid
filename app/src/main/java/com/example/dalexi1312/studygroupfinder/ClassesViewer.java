package com.example.dalexi1312.studygroupfinder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ClassesViewer extends AppCompatActivity {
    private Button mClassesFoundButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classes_viewer);

        mClassesFoundButton =(Button) findViewById(R.id.takeMeToGroupsButton);
        mClassesFoundButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                goToClassView();
            }
        });
    }
    private void goToClassView() {
        Intent intent = new Intent(this, TabsView.class);
        startActivity(intent);
    }
}
