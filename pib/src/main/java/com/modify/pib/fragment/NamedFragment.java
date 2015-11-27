package com.modify.pib.fragment;

import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;

public abstract class NamedFragment extends Fragment {

    private int title;

    @StringRes
    public int getTitle() {
        return title;
    }

    public void setTitle(@StringRes int title) {
        this.title = title;
    }

}
