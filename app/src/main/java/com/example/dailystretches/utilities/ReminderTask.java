package com.example.dailystretches.utilities;

import android.content.Context;

public class ReminderTask {

    public static void issueReminder(Context context){
        NotificationsUtil.stretchReminder(context);
    }
}
