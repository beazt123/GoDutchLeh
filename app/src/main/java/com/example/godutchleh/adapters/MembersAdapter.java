package com.example.godutchleh.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.godutchleh.R;
import com.example.godutchlib.Member;

import java.util.ArrayList;
import java.util.Random;

public class MembersAdapter extends RecyclerView.Adapter<MembersAdapter.ViewHolder> {

    private ArrayList<Member> mFriendsList;
    Context context;
    Random random;
    int defaultImages[];

    public MembersAdapter(Context context, ArrayList<Member> friendsList, int[] defaultImages) {
        this.mFriendsList = friendsList;
        this.context = context;
        this.random = new Random(1);
        this.defaultImages = defaultImages;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.member_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //bind specific data to the views in each itemView
        holder.name.setText(mFriendsList.get(position).getName());
        //in final implementation, each member should have their own photo but for now we use a random one
        int randomImageId = random.nextInt(11); //pick a random image Id from the list of default images
        holder.profilePhoto.setImageResource(defaultImages[randomImageId]);
    }

    @Override
    public int getItemCount() {
        return mFriendsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //after receiving the itemView from onCreateViewHolder, assign the required views to it
        TextView name;
        ImageView profilePhoto;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.memberName);
            profilePhoto = itemView.findViewById(R.id.profile_image);
        }
    }
}
