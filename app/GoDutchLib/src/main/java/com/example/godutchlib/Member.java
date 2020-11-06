package com.example.godutchlib;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class Member implements Parcelable {

    static HashMap<Integer, Member> mUsedIds;
    static ArrayList<Integer> mIdList;
    String mName;
    Integer mId;
    boolean mStatus;
    double mDebt;
    double mLent;
    HashMap<Integer, Event> mEvents;

    boolean IN_DEBT = false;
    boolean NOT_IN_DEBT = true;

    protected Member(Parcel in) {
        mName = in.readString();
        mId = in.readInt();
        mStatus = in.readByte() != 0;
        mDebt = in.readDouble();
        mLent = in.readDouble();
        IN_DEBT = in.readByte() != 0;
        NOT_IN_DEBT = in.readByte() != 0;
    }

    public static final Creator<Member> CREATOR = new Creator<Member>() {
        @Override
        public Member createFromParcel(Parcel in) {
            return new Member(in);
        }

        @Override
        public Member[] newArray(int size) {
            return new Member[size];
        }
    };

    public static void setIds(int n) {
        // populate mIdList with a bunch of numbers from 0 to n (simulate Ids from backend)
        for (int i=0; i<n; i++) {
            mIdList.add(i);
        }
    }

    public Member(String name) {
        // create a Member obj with name and first available Id in mIdList
        for (int id : mIdList) {
            if (!(mUsedIds.keySet().contains(id))) {
                this.mId = id;
            }
        }
        mStatus = NOT_IN_DEBT;
        mDebt = 0;
        mLent = 0;

        mUsedIds.put(this.mId, this);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mName);
        dest.writeInt(mId);
        dest.writeByte((byte) (mStatus ? 1 : 0));
        dest.writeDouble(mDebt);
        dest.writeDouble(mLent);
        dest.writeByte((byte) (IN_DEBT ? 1 : 0));
        dest.writeByte((byte) (NOT_IN_DEBT ? 1 : 0));
    }

    @Override
    public String toString() {
        return "Member{" +
                "mId=" + mId +
                '}';
    }
}
