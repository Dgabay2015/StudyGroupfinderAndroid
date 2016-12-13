package com.example.dalexi1312.studygroupfinder;
//the group Object

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;

public class Group implements Parcelable{
    public Group(String groupId,String nameOfGroup,String[]members,String meetingTimes,String locationName){
        mGroupId=groupId;
        mNameOfGroup=nameOfGroup;
        mMembers=members;
        mLocationName=locationName;
        mMeetingTimes=meetingTimes;
        //here is set gravatar for now
        mGravatar ="slackgrav1.png";

    }
    private String mGroupId;
    private String mNameOfGroup;
    private String [] mMembers;
    private String mMeetingTimes;
    private String mLocationName;
    private int mNumberOfMembers;
    private String mGravatar;
    //constructor that creates a group






    public String getGravatar() {
        return mGravatar;
    }

    public void setGravatar(String gravatar) {
        mGravatar = gravatar;
    }

    public String getGroupId() {
        return mGroupId;
    }

    public void setGroupId(String groupId) {
        mGroupId = groupId;
    }

    public String getLocationName() {
        return mLocationName;
    }

    public void setLocationName(String locationName) {
        mLocationName = locationName;
    }

    public String getMeetingTimes() {
        return mMeetingTimes;
    }

    public void setMeetingTimes(String meetingTimes) {
        mMeetingTimes = meetingTimes;
    }

    public String[] getMembers() {
        return mMembers;
    }

    public void setMembers(String [] members) {
        mMembers = members;
    }
    public int getNumberOfMembers() {
        mNumberOfMembers= mMembers.length;
        return mNumberOfMembers;
    }
    public String getNameOfGroup() {
        return mNameOfGroup;
    }

    public void setNameOfGroup(String nameOfGroup) {
        mNameOfGroup = nameOfGroup;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mGroupId);
        dest.writeString(mNameOfGroup);
        dest.writeString(mLocationName);
        dest.writeString(mGravatar);
        dest.writeStringArray(mMembers);
        dest.writeInt(mNumberOfMembers);
        dest.writeString(mMeetingTimes);
    }
    private Group(Parcel in){
        mGroupId = in.readString();
        mNameOfGroup = in.readString();
        mLocationName = in.readString();
        mGravatar = in.readString();
        mMembers = in.createStringArray();
        mNumberOfMembers = in.readInt();
        mMeetingTimes = in.readString();
    }
    public static final Creator <Group> CREATOR = new Creator<Group>() {
        @Override
        public Group createFromParcel(Parcel source) {
            return new Group(source);
        }

        @Override
        public Group[] newArray(int size) {
            return new Group[size];
        }
    };
}

