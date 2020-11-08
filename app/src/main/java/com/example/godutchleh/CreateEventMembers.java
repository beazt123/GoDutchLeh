package com.example.godutchleh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.godutchleh.adapters.MembersAdapter;
import com.example.godutchlib.Member;

import java.util.ArrayList;

public class CreateEventMembers extends AppCompatActivity {

    private static final String TAG = "CreateEventMembers";

    //UI components
    private RecyclerView mMemberRecyclerView;
    private RecyclerView.Adapter mMemberAdapter;
    private RecyclerView.LayoutManager mMemberLayoutManager;

    //vars
    public ArrayList<Member> mFakeMembers = new ArrayList<>();
    public final int defaultImages[] = {R.drawable.courage_the_dog, R.drawable.ashketchum, R.drawable.dexter, R.drawable.johnny_bravo,
            R.drawable.kim_possible, R.drawable.knd_girl, R.drawable.paulina, R.drawable.popeye, R.drawable.popeye,
            R.drawable.tasmanian_devil, R.drawable.wolf};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("creating CreateEventMembers activity");
        setContentView(R.layout.activity_create_event_members);

        mMemberRecyclerView = findViewById(R.id.recyclerView);

        getFakeMembers();
        Log.d(TAG, "onCreate: fake members made");

        mMemberLayoutManager = new LinearLayoutManager(this);
        mMemberRecyclerView.setLayoutManager(mMemberLayoutManager);
        mMemberAdapter = new MembersAdapter(this, mFakeMembers, defaultImages);
        mMemberRecyclerView.setAdapter(mMemberAdapter);
        Log.e(TAG, "onCreate: recyclerview setup");

        Log.d(TAG, "onCreate: recyclerview set up");


    }

    public void getFakeMembers() {
        Member.setIds(20);
        mFakeMembers.add(new Member("sally"));
        mFakeMembers.add(new Member("wally"));
        /*mFakeMembers.add(new Member("dally"));
        mFakeMembers.add(new Member("fally"));
        mFakeMembers.add(new Member("gally"));
        mFakeMembers.add(new Member("hally"));
        mFakeMembers.add(new Member("jally"));
        mFakeMembers.add(new Member("kally"));
        mFakeMembers.add(new Member("lally"));*/
    }
}