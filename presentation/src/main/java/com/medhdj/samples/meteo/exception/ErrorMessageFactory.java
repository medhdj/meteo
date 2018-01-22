package com.medhdj.samples.meteo.exception;

import android.content.Context;

import com.medhdj.samples.meteo.R;

/**
 * Created by medhdj on 21.01.18.
 */

public class ErrorMessageFactory {
    public static String create(Context context, Throwable throwable) {
        String message = context.getString(R.string.error_message);

        //check throwable type to custom msg....

        return message;
    }
}
