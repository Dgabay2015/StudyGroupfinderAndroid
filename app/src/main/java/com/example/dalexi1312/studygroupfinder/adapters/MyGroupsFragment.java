package com.example.dalexi1312.studygroupfinder.adapters;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.dalexi1312.studygroupfinder.Group;
import com.example.dalexi1312.studygroupfinder.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyGroupsFragment extends Fragment {
    String[ ] members={"David", "Brandon", "danh","elizabeth","Newil"};
    String[ ] members2={"David", "Brandon", "danh","elizabeth","Newil","keith"};
    String[ ] members3={"David", "Brandon", "danh","elizabeth","Newil","john","felesha"};
    String[ ] members4={"David", "Brandon", "danh","elizabeth","Newil","tom","vein","Paul","forker","spoon","walker"};

    Group mGroupTest=new Group("TestID1","WE study HARD",members,"5:30pm","EE106","COP4020");
    Group mGroupTest1=new Group("TestID2","Outside studiers",members2,"5:30pm","EE106","CEN4010");
    Group mGroupTest2=new Group("TestID3","Computer Scientist",members4,"5:30pm","EE107","COP4020");
    Group mGroupTest3=new Group("TestID4","Dr. Huang",members3,"5:30pm","EE108","CEN4010");
    Group mGroupTest4=new Group("TestID5","Juniors Study",members,"5:30pm","EE109","CEN4010");
    Group mGroupTest5=new Group("TestID6","MostValuableStudy",members3,"5:30pm","EE100","CEN4010");

    Group[] mGroups = {
            mGroupTest,mGroupTest1,mGroupTest2,mGroupTest3,mGroupTest4,mGroupTest5
    };
    Group[] mGroups2;
    private ListView mListViewOfGroupsJoined; //will be the list og groups you can be a part of based on yor class selection

    public MyGroupsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview= inflater.inflate(R.layout.fragment_my_groups, container, false);
        mListViewOfGroupsJoined = (ListView)rootview.findViewById(R.id.myGroupsListView);

        ListAdapter adapter = new ListAdapter(rootview.getContext(),mGroups);
        mListViewOfGroupsJoined.setAdapter(adapter);




        return rootview;
    }

}
