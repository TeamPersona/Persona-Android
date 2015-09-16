package com.modify.pib;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.modify.pib.dao.ValueOpportunityProvider;

public class SecondFragment extends Fragment {

    protected RecyclerView recyclerView;
    protected RecyclerView.LayoutManager layoutManager;
    protected VoListAdapter voListAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment2, container, false);
        rootView.setTag("SecondFragment");

        recyclerView = (RecyclerView) rootView.findViewById(R.id.vo_list);

        layoutManager = new LinearLayoutManager(getActivity());

        voListAdapter = new VoListAdapter(new ValueOpportunityProvider().readVOs());

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(voListAdapter);

        return rootView;
    }
}