package com.example.godutchleh.eventlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

import com.example.godutchleh.R;


public class EventAdapter extends ArrayAdapter<Event> {
    private int resourceId;

    //save view as cache
    class ViewHolder {
        ImageView eventImage;
        TextView eventName;
        TextView eventTime;
        TextView eventSpending;
        TextView eventMembers;
    }

    //instructor, accept data
    public EventAdapter(@NonNull Context context, int textViewResourceId, @NonNull List<Event> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        Event event = getItem(position); //get event instance

        View view;
        ViewHolder viewHolder;
        if (convertView == null) {

            // Avoid reloading the layout every time the ListView is scrolled
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);

            // Avoid getting the control instance every time getView() is called
            viewHolder = new ViewHolder();
            viewHolder.eventImage = view.findViewById(R.id.event_image);
            viewHolder.eventName = view.findViewById(R.id.event_name);
            viewHolder.eventTime = view.findViewById(R.id.event_time);
            viewHolder.eventSpending = view.findViewById(R.id.event_spending);
            viewHolder.eventMembers = view.findViewById(R.id.event_members);

            // save instance of viewHolder to view
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.eventImage.setImageResource(event.getImageId());
        viewHolder.eventName.setText(event.getEventName());
        viewHolder.eventTime.setText(event.getEventTime());
        viewHolder.eventMembers.setText("Members: "+event.getEventMembers());
        viewHolder.eventSpending.setText("Total Spending: "+event.getEventSpending());
        return view;
    }
}
