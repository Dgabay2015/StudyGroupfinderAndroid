package com.example.dalexi1312.studygroupfinder;
//the group Object

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;

public class Group implements Parcelable{
    public Group(String nameOfGroup, String locationName, String meetingTimes,String Subject) { //when you create a group you use this constructor since you dont know the group id, gravatar,number of members, members
        mNameOfGroup = nameOfGroup;
        mLocationName = locationName;
        mMeetingTimes = meetingTimes;
        mSubject=Subject;
    }

    public Group(){ //empty constructor so you must create the properties using function
        mGravatar ="slackgrav1.png";

    };
    //constructor that creates a group
    public Group(String groupId,String nameOfGroup,String[]members,String meetingTimes,String locationName, String Subject){
        mGroupId=groupId;
        mNameOfGroup=nameOfGroup;
        mMembers=members;
        mLocationName=locationName;
        mMeetingTimes=meetingTimes;
        mSubject= Subject;
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
    private String mSubject;


    public String getSubject() {
        return mSubject;
    }

    public void setSubject(String subject) {
        mSubject = subject;
    }

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
        dest.writeString(mSubject);
    }
    private Group(Parcel in){
        mGroupId = in.readString();
        mNameOfGroup = in.readString();
        mLocationName = in.readString();
        mGravatar = in.readString();
        mMembers = in.createStringArray();
        mNumberOfMembers = in.readInt();
        mMeetingTimes = in.readString();
        mSubject = in.readString();
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

