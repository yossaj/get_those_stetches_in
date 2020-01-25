package com.example.dailystretches.utilities;

import android.content.Context;

import androidx.annotation.NonNull;

import java.util.concurrent.TimeUnit;
import com.firebase.jobdispatcher.Driver;
import com.firebase.jobdispatcher.FirebaseJobDispatcher;
import com.firebase.jobdispatcher.GooglePlayDriver;
import com.firebase.jobdispatcher.Job;
import com.firebase.jobdispatcher.Lifetime;
import com.firebase.jobdispatcher.Trigger;

public class TimedReminderUtil {

    private static final int REMINDER_INTERVAL_MINUTES = 60;
    private static final int REMINDER_INTERVAL_SECONDS = (int) (TimeUnit.MINUTES.toSeconds(REMINDER_INTERVAL_MINUTES));
    private static final int SYNC_FLEXTIME_SECONDS = REMINDER_INTERVAL_SECONDS;

    private static final String REMINDER_JOB_TAG = "stretch_reminder_tag";
    private static boolean sInitialized = false;

    synchronized public static void scheduleReminder(@NonNull final Context context) {

        if (sInitialized) return;

        Driver driver = new GooglePlayDriver(context);
        FirebaseJobDispatcher dispatcher = new FirebaseJobDispatcher(driver);
        Job constraintReminderJob = dispatcher.newJobBuilder()
                .setService(StretchFirebaseJobService.class)
                .setRecurring(true)
                .setTag(REMINDER_JOB_TAG)
                .setLifetime(Lifetime.FOREVER)
                .setTrigger(Trigger.executionWindow(
                        REMINDER_INTERVAL_SECONDS, REMINDER_INTERVAL_SECONDS + SYNC_FLEXTIME_SECONDS))
                .setReplaceCurrent(true)
                .build();

        dispatcher.schedule(constraintReminderJob);

        sInitialized = true;
    }
}
