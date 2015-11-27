package com.modify.pib.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.modify.pib.R;
import com.modify.pib.model.ValueOpportunity;
import com.modify.pib.network.RequestManager;

import java.text.NumberFormat;

public class VoDetailFragment extends NamedFragment {

    public static final String VO_DATA = "vo_data";
    private ValueOpportunity currentVo;
    private ImageLoader imageLoader;

    private NetworkImageView companyImage;
    private TextView voTitle;
    private TextView companyName;
    private TextView valueText;
    private ProgressBar progressBar;
    private AppCompatButton dismissBtn;
    private AppCompatButton participateBtn;
    private TextView shortDescription;
    private TextView viewLongDescription;

    public VoDetailFragment() {
        super();
        this.setTitle(R.string.title_vo_detail);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);

        companyImage = (NetworkImageView) rootView.findViewById(R.id.detail_company_image);
        voTitle = (TextView) rootView.findViewById(R.id.detail_vo_title);
        companyName = (TextView) rootView.findViewById(R.id.detail_company_name);
        valueText = (TextView) rootView.findViewById(R.id.detail_value_text);
        progressBar = (ProgressBar) rootView.findViewById(R.id.detail_progress_bar);

        dismissBtn = (AppCompatButton) rootView.findViewById(R.id.btn_detail_dismiss);
        participateBtn = (AppCompatButton) rootView.findViewById(R.id.btn_detail_participate);

        shortDescription = (TextView) rootView.findViewById(R.id.detail_short_description);
        viewLongDescription = (TextView) rootView.findViewById(R.id.detail_view_long_description);

        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();

        Bundle args = getArguments();
        if (args != null) {
            ValueOpportunity data = (ValueOpportunity) args.getSerializable(VO_DATA);
            updateDetailsView(data);
        } else if (currentVo != null) {
            updateDetailsView(currentVo);
        }
    }

    public void updateDetailsView(ValueOpportunity data) {
        imageLoader = RequestManager.getInstance(this.getActivity().getApplicationContext()).getImageLoader();
        companyImage.setImageUrl(data.imageUrl, imageLoader);
        voTitle.setText(data.voTitle);
        companyName.setText(data.companyName);
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(data.locale);
        valueText.setText(currencyFormat.format(data.value));
        progressBar.setMax(data.maxParticipants);
        progressBar.setProgress(data.currParticipants);
        shortDescription.setText(data.shortDescription);

        currentVo = data;
    }

}