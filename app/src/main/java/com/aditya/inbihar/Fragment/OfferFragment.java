package com.aditya.inbihar.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.aditya.inbihar.R;
import com.aditya.inbihar.UI.BottomActivity;
import com.aditya.inbihar.UI.ItemActivity;

public class OfferFragment extends Fragment {

    ImageView img_pen_offer;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_offer, container, false);
        img_pen_offer=v.findViewById(R.id.img_pen_offer);

        img_pen_offer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(), ItemActivity.class);
                startActivity(intent);
            }
        });

        return v;
    }

    public void onResume(){
        super.onResume();
        // Set title bar
        ((BottomActivity) getActivity())
                .setActionBarTitle("Offer Zone");

    }
}