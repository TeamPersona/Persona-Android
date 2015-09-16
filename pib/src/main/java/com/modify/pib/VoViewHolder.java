package com.modify.pib;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class VoViewHolder extends RecyclerView.ViewHolder {

    TextView companyName;
    TextView description;
    TextView value;

    public VoViewHolder(View itemView) {
        super(itemView);
        companyName = (TextView) itemView.findViewById(R.id.company_text);
        description = (TextView) itemView.findViewById(R.id.description_text);
        value = (TextView) itemView.findViewById(R.id.value_text);
    }

}
