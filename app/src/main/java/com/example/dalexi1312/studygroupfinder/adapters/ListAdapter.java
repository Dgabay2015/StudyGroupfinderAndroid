package com.example.dalexi1312.studygroupfinder.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dalexi1312.studygroupfinder.R;

public class ListAdapter extends BaseAdapter {
    private Context mContext;
    private String [] mGroupers;
    public ListAdapter(Context context, String[] groupers){
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
            holder.iconImageView= (ImageView) convertView.findViewById(R.id.iconImageView);
            holder.nameOfGroup= (TextView) convertView.findViewById(R.id.nameTextView);

            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder)convertView.getTag();
        }


        return null;
    }
    private static class ViewHolder{
        ImageView iconImageView; //public by default
        TextView nameOfGroup;

    }


}
