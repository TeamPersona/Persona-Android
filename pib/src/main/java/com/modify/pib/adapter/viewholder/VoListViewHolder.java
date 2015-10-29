package com.modify.pib.adapter.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.android.volley.toolbox.NetworkImageView;
import com.modify.pib.R;
import com.modify.pib.listener.RecyclerViewItemListener;

public class VoListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public NetworkImageView imageView;
    public TextView voTitle;
    public TextView companyName;
    public TextView value;
    public ProgressBar progressBar;

    private final RecyclerViewItemListener listener;

    public VoListViewHolder(View itemView, RecyclerViewItemListener listener) {
        super(itemView);
        itemView.setOnClickListener(this);
        voTitle = (TextView) itemView.findViewById(R.id.vo_title);
        companyName = (TextView) itemView.findViewById(R.id.company_name);
        value = (TextView) itemView.findViewById(R.id.value_text);
        progressBar = (ProgressBar) itemView.findViewById(R.id.progress_bar);
        imageView = (NetworkImageView) itemView.findViewById(R.id.company_image);
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        if (listener != null) {
            listener.onItemClicked(v, getAdapterPosition());
        }
    }
}