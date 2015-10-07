package com.modify.pib;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.modify.pib.model.ValueOpportunity;
import com.modify.pib.network.RequestManager;

import java.text.NumberFormat;
import java.util.List;

public class VoListAdapter extends RecyclerView.Adapter<VoListAdapter.VoViewHolder> {

    private final List<ValueOpportunity> voList;
    private final ImageLoader imageLoader;

    VoListAdapter(Context context, List voList) {
        this.voList = voList;
        imageLoader = RequestManager.getInstance(context).getImageLoader();
    }

    public static class VoViewHolder extends RecyclerView.ViewHolder {

        NetworkImageView imageView;
        TextView companyName;
        TextView description;
        TextView value;
        ProgressBar progressBar;

        public VoViewHolder(View itemView) {
            super(itemView);
            companyName = (TextView) itemView.findViewById(R.id.company_text);
            description = (TextView) itemView.findViewById(R.id.description_text);
            value = (TextView) itemView.findViewById(R.id.value_text);
            progressBar = (ProgressBar) itemView.findViewById(R.id.progress_bar);
            imageView = (NetworkImageView) itemView.findViewById(R.id.company_image);
        }

    }

    @Override
    public VoViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        final LayoutInflater inflator = LayoutInflater.from(viewGroup.getContext());
        final View v = inflator.inflate(R.layout.vo_item2, viewGroup, false);
        return new VoViewHolder(v);
    }
    @Override
    public void onBindViewHolder(VoViewHolder viewHolder, int i) {
        final ValueOpportunity vo = voList.get(i);
        viewHolder.companyName.setText(vo.companyName);
        viewHolder.description.setText(vo.description);
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

}
