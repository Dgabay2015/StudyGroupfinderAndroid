package com.example.dalexi1312.studygroupfinder;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class MyGroups extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_groups);
        String[ ] groups={"super stdier CEN4010", "cool bean study COP4302","Software engineering Cen4010"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,groups);
        setListAdapter(adapter);

    }
}
