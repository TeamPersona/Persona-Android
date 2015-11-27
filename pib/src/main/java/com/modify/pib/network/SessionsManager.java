package com.modify.pib.network;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class SessionsManager {

    SharedPreferences sharedPref;
    Editor editor;

    Context context;

    // Keys for login
    private static final String KEY_IS_LOGGEDIN = "isLoggedIn";

    // FIXME: Not sure if static String literals should be organized somewhere
    private static final String PREF_NAME = "PIB";

    public SessionsManager(Context context) {
        this.context = context;
        sharedPref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = sharedPref.edit();
    }

    /*
     * Return if commit is successful
     */
    public boolean setLoggedIn(boolean loggedIn) {
        editor.putBoolean(KEY_IS_LOGGEDIN, loggedIn);
        return editor.commit();
    }

    public boolean isLoggedIn() {
        return sharedPref.getBoolean(KEY_IS_LOGGEDIN, false);
    }

}
