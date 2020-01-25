package com.example.dailystretches;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dailystretches.utilities.TimedReminderUtil;

public class MainActivity extends AppCompatActivity implements StretchAdapter.AdapterOnCheckedItemListener {

    private RecyclerView mStretchRecyclerView;
    private StretchAdapter mStretchAdapter;
    private String[] stretches;
    private Context context;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TimedReminderUtil.scheduleReminder(this);
        stretches = getStrings();

        mStretchRecyclerView = findViewById(R.id.main_recycler_view);
        mStretchRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mStretchAdapter = new StretchAdapter(this, this);
        mStretchAdapter.setStretchData(stretches);
        mStretchRecyclerView.setAdapter(mStretchAdapter);
        context = this;


    }

    public String[] getStrings(){

        String[] someStretches = {
                "Downward facing dog",
                "Squat hammy stretch",
                "Long kow-tow"
        };

        return someStretches;
    }

    public String[] getNewStretches(String tvText){
        tvText.toLowerCase();
        String[] newStringList = new String[stretches.length - 1];
        int counter = 0;
        for(int i = 0; i < stretches.length; i++){
            if(!tvText.equals(stretches[i])){
                newStringList[counter] = stretches[i];
                counter++;
            }
        }
        return newStringList;

    };


    @Override
    public void onChecked(TextView textView, CheckBox checkBox) {
        stretches = getNewStretches(textView.getText().toString());
        mStretchAdapter.setStretchData(stretches);
        mStretchRecyclerView.setAdapter(mStretchAdapter);
    }


}

