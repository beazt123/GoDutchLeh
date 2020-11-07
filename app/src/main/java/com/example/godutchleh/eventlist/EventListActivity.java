package com.example.godutchleh.eventlist;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import com.example.godutchleh.R;

public class EventListActivity extends AppCompatActivity {

    //save event data
    private List<Event> EventList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_list);

        // get the date and use it to create adapter
        testEvents(); //initialize
        EventAdapter adapter=new EventAdapter(EventListActivity.this, R.layout.event_item, EventList);

        // transfer the data from adapter to listView
        ListView listView=findViewById(R.id.event_list_view);
        listView.setAdapter(adapter);

        // onClick method for each event
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Event fruit=EventList.get(position);
                Toast.makeText(EventListActivity.this, fruit.getEventName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void testEvents(){
        for(int i=0;i<5;i++){
            Event a=new Event("Event a", "07/11/2020", "20", "3", R.drawable.ashketchum);
            EventList.add(a);
            Event b=new Event("Event b", "08/11/2020", "15", "4", R.drawable.ashketchum);
            EventList.add(b);
        }
    }
}