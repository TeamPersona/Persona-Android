package com.modify.pib;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.modify.pib.model.ValueOpportunity;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class VoListAdapter extends RecyclerView.Adapter<VoViewHolder> {

    private final List<ValueOpportunity> voList;

    VoListAdapter(List voList) {
        this.voList = voList;
    }

    @Override
    public VoViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        final LayoutInflater inflator = LayoutInflater.from(viewGroup.getContext());
        final View v = inflator.inflate(R.layout.vo_item, viewGroup, false);
        return new VoViewHolder(v);
    }
    @Override
    public void onBindViewHolder(VoViewHolder viewHolder, int i) {
        viewHolder.companyName.setText(voList.get(i).getCompanyName());
        viewHolder.description.setText(voList.get(i).getDescription());
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.CANADA);
        viewHolder.value.setText(currencyFormat.format(voList.get(i).getValue()));
    }

    @Override
    public int getItemCount() {
        return voList.size();
    }

}
