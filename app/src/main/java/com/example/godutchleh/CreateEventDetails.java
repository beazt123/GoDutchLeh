package com.example.godutchleh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;

import java.util.Date;

public class CreateEventDetails extends AppCompatActivity {

    //vars
    String mEventName;
    String mDate; //set only when event is created
    String mTime; //set only when event is created

    //UI components
    EditText EventNameEditText;
    Button AddMembersButton;
    Button AddPhotoButton;
    Button SaveButton;
    Menu OverallMenu;
    Button BackArrowButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event_details);
    }

}