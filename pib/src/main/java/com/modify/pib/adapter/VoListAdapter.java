package com.modify.pib.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.android.volley.toolbox.ImageLoader;
import com.modify.pib.R;
import com.modify.pib.adapter.viewholder.VoListViewHolder;
import com.modify.pib.listener.RecyclerViewItemListener;
import com.modify.pib.listener.VoItemListener;
import com.modify.pib.model.ValueOpportunity;
import com.modify.pib.network.RequestManager;

import java.text.NumberFormat;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.UUID;

public class VoListAdapter extends RecyclerView.Adapter<VoListViewHolder> implements RecyclerViewItemListener {

    private final List<ValueOpportunity> voList;
    private final ImageLoader imageLoader;

    private VoItemListener onVoItemListener;

    public VoListAdapter(Context context, List<ValueOpportunity> voList) {
        this.voList = voList;
        imageLoader = RequestManager.getInstance(context).getImageLoader();
    }

    @Override
    public VoListViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        final LayoutInflater inflator = LayoutInflater.from(viewGroup.getContext());
        final View v = inflator.inflate(R.layout.vo_item, viewGroup, false);
        return new VoListViewHolder(v, this);
    }

    @Override
    public void onBindViewHolder(VoListViewHolder viewHolder, int i) {
        final ValueOpportunity vo = voList.get(i);
        viewHolder.voTitle.setText(vo.voTitle);
        viewHolder.companyName.setText(vo.companyName);
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(vo.locale);
        viewHolder.value.setText(currencyFormat.format(vo.value));
        viewHolder.progressBar.setMax(vo.maxParticipants);
        viewHolder.progressBar.setProgress(vo.currParticipants);
        viewHolder.imageView.setImageUrl(vo.imageUrl, imageLoader);
    }

    @Override
    public int getItemCount() {
        return voList.size();
    }

    public VoItemListener getVoItemListener() {
        return onVoItemListener;
    }

    public void setVoItemListener(VoItemListener onVoItemListener) {
        this.onVoItemListener = onVoItemListener;
    }

    @Override
    public void onItemClicked(View view, int position) {
        if(onVoItemListener != null) {
            onVoItemListener.onVoItemClicked(voList.get(position));
        }
    }
}
