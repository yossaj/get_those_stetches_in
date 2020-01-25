package com.example.dailystretches.utilities;

import android.app.IntentService;
import android.content.Intent;

import androidx.annotation.Nullable;

public class StretchReminderIntentService extends IntentService {


    public StretchReminderIntentService(String name) {
        super("StretchReminderIntentService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        ReminderTask.issueReminder(this);
    }
}
