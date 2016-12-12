package com.example.dalexi1312.studygroupfinder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class ClassesViewer extends AppCompatActivity {
    private Button mClassesFoundButton;
    private Spinner mSpinner;
    ArrayAdapter<CharSequence> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classes_viewer);
        mSpinner=(Spinner)findViewById(R.id.allClassesspinner);
        mAdapter=ArrayAdapter.createFromResource(this,R.array.course_names,android.R.layout.simple_spinner_item);
        mAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(mAdapter);





        mClassesFoundButton =(Button) findViewById(R.id.takeMeToGroupsButton);
        mClassesFoundButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                goToClassView();
            }
        });
    }
    private void goToClassView() {
        Intent intent = new Intent(this, classview.class);
        startActivity(intent);
    }
}
