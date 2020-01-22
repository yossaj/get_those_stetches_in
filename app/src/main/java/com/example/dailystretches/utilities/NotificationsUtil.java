package com.example.dailystretches.utilities;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;

import com.example.dailystretches.MainActivity;
import com.example.dailystretches.R;

public class NotificationsUtil {

    private static final int STRETCH_REMINDER_NOTIFICATION_ID = 3345;
    private static final int STRETCH_REMINDER_PENDING_INTENT_ID = 4456;
    private static final String CHANNEL_ID = "STRETCHES";

    public static void stretchReminder(Context context){

        NotificationManager notificationManager = (NotificationManager)
                context.getSystemService(Context.NOTIFICATION_SERVICE);


        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setColor(ContextCompat.getColor(context, R.color.colorPrimary))
                .setContentTitle("Hammy")
                .setContentText("Hammy")
                .setSmallIcon(R.drawable.stretch)
                .setStyle(new NotificationCompat.BigTextStyle().bigText("Hammy"))
                .setDefaults(Notification.DEFAULT_VIBRATE)
                .setContentIntent(contentIntent(context))
                .setDefaults(Notification.DEFAULT_VIBRATE)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setAutoCancel(true);


        notificationManager.notify(STRETCH_REMINDER_NOTIFICATION_ID, builder.build());


    }

    private static PendingIntent contentIntent(Context context) {
        Intent startActivityIntent = new Intent(context, MainActivity.class);
        return PendingIntent.getActivity(
                context,
                STRETCH_REMINDER_PENDING_INTENT_ID,
                startActivityIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
    }


}
