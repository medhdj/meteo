package com.medhdj.samples.meteo;

import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by medhdj on 22/01/2018.
 */

public class DateUtils {
    public static SimpleDateFormat DATE_FORMAT_OUT =
            new SimpleDateFormat("EEEE d MMMM, HH':'mm", Locale.getDefault());

    public static String formatDate(long timeStamp) {
        try {
            return DATE_FORMAT_OUT.format(new Date(timeStamp));
        } catch (Exception e) {
            Log.e(DateUtils.class.getSimpleName(), "formatDate", e);
            return "";
        }
    }
}
