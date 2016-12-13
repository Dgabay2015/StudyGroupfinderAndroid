package com.example.dalexi1312.studygroupfinder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class ClassesViewer extends AppCompatActivity {
    private Button mClassesFoundButton;
    private Spinner mSpinner;
    public static final String DAILY_FORECAST= "DAILY FORECAST";
    ArrayAdapter<CharSequence> mAdapter;
    public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    public String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classes_viewer);
        mSpinner=(Spinner)findViewById(R.id.allClassesspinner);
        mAdapter=ArrayAdapter.createFromResource(this,R.array.course_names,android.R.layout.simple_spinner_item);
        mAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(mAdapter);

        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //if item in spinner select here you would do something
                message= parent.getItemAtPosition(position)+" class";
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });






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
        intent.putExtra(EXTRA_MESSAGE, message);

        startActivity(intent);
    }
}
