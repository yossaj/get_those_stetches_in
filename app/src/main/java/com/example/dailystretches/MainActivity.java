package com.example.dailystretches;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.NotificationManager;
import android.os.Bundle;
import android.view.View;

import com.example.dailystretches.utilities.NotificationsUtil;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mStretchRecyclerView;
    private StretchAdapter mStretchAdapter;
    private String[] stretches;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        stretches = getStrings();

        mStretchRecyclerView = findViewById(R.id.main_recycler_view);
        mStretchRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mStretchAdapter = new StretchAdapter(this);
        mStretchAdapter.setStretchData(stretches);
        mStretchRecyclerView.setAdapter(mStretchAdapter);




    }

    public String[] getStrings(){

        String[] someStretches = {
                "Downward facing dog",
                "Squat hammy stetch",
                "Kowtow Back Stretch"
        };

        return someStretches;
    }

    public void launchNotifications(View view){
        NotificationsUtil.stretchReminder(this);

    }

}
