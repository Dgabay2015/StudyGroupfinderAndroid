package com.example.dalexi1312.studygroupfinder.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dalexi1312.studygroupfinder.Group;
import com.example.dalexi1312.studygroupfinder.R;

public class ListAdapter extends BaseAdapter {
    private Context mContext;
    private Group[] mGroupers;


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






    public ListAdapter(Context context, Group[] groupers){
        mContext=context;
        mGroupers= groupers;
    }


    @Override
    public int getCount() {
        return mGroupers.length;
    }

    @Override
    public Object getItem(int position) {
        return mGroupers[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;//not used
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if(convertView == null)
        {
            //brand new
            convertView = LayoutInflater.from(mContext).inflate(R.layout.list_of_groups,null);
            holder=new ViewHolder();
            holder.iconImageView= (ImageView) convertView.findViewById(R.id.gravatarImageView);
            holder.nameOfGroup= (TextView) convertView.findViewById(R.id.groupNameTextView);
            holder.amountOfGroupMembers=(TextView)convertView.findViewById(R.id.amountOfGroupMembersTextView);


            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder)convertView.getTag();
        }

        Group group = mGroupers[position];

        holder.iconImageView.setImageResource(R.drawable.slackgrav1);
        holder.nameOfGroup.setText(group.getNameOfGroup());
        holder.amountOfGroupMembers.setText(group.getNumberOfMembers()+" members");



        return convertView;
    }
    private static class ViewHolder{
        ImageView iconImageView; //public by default
        TextView nameOfGroup;
        TextView amountOfGroupMembers;

    }


}
