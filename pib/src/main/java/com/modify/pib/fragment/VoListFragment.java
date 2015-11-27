package com.modify.pib.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.modify.pib.R;
import com.modify.pib.adapter.VoListAdapter;
import com.modify.pib.dao.ValueOpportunityProvider;
import com.modify.pib.listener.VoItemListener;
import com.modify.pib.model.ValueOpportunity;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.UUID;

public class VoListFragment extends NamedFragment implements SwipeRefreshLayout.OnRefreshListener {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private VoListAdapter voListAdapter;
    private ValueOpportunityProvider dataProvider;
    private List<ValueOpportunity> data;
    private VoItemListener itemListener;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataProvider = new ValueOpportunityProvider();
        data = dataProvider.readAll();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_volist, container, false);

        swipeRefreshLayout = (SwipeRefreshLayout) rootView.findViewById(R.id.vo_list_refresh_layout);
        swipeRefreshLayout.setOnRefreshListener(this);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.vo_list);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getActivity());

        voListAdapter = new VoListAdapter(this.getActivity().getApplicationContext(), data);
        voListAdapter.setVoItemListener(itemListener);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(voListAdapter);

        return rootView;
    }

    /*
     * onAttach(Context context) does not get called because of the
     * use of AppCompatActivity in the support library
     */
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            itemListener = (VoItemListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + "must implement RecyclerViewItemListener");
        }
    }

    @Override
    public void onRefresh() {
        data = dataProvider.readAll();
        onRefreshComplete();
    }

    private void onRefreshComplete() {
        voListAdapter.notifyDataSetChanged();
        swipeRefreshLayout.setRefreshing(false);
    }
}