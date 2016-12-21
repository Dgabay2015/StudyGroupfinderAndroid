package com.example.dalexi1312.studygroupfinder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class AddGroup extends AppCompatActivity {
   private Spinner mSpinner;
    ArrayAdapter<CharSequence> mAdapter;
    private Button mAddGroupButton;
    public String message;
    private EditText mNameEditText; //the name of the group edit text
    public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_group);
        mSpinner=(Spinner)findViewById(R.id.spinnerClasses);
        mAdapter=ArrayAdapter.createFromResource(this,R.array.course_names,android.R.layout.simple_spinner_item);
        mAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(mAdapter);
        mNameEditText = (EditText)findViewById(R.id.GroupnameeditText);

        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               Toast.makeText(getBaseContext(),parent.getItemAtPosition(position)+" is the best class!!",Toast.LENGTH_SHORT).show();
                message = parent.getItemAtPosition(position)+"";
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        mAddGroupButton= (Button)findViewById(R.id.buttonSubmit);
        mAddGroupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Group newGroup = new Group(mNameEditText.getText().toString(),"GS 119","7:30pm" , "CEN4010");
               //FOR NOW i WILL REMOVE THIS OPTION

                //getting errors so i have to rethink the button

                // goToGroupView();
            }
        });


    }
    private void goToGroupView()
    {
        Intent intent = new Intent(this,GroupPage.class);
        Group newGroup = new Group(mNameEditText.getText().toString(),"GS 119","7:30pm","CEN4010");
        intent.putExtra(EXTRA_MESSAGE,newGroup);
        startActivity(intent);
    }

}
