package com.aditya.inbihar.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.aditya.inbihar.R;
import com.aditya.inbihar.UI.BottomActivity;
import com.aditya.inbihar.UI.EditProfileActivity;
import com.aditya.inbihar.UI.MyOrdersActivity;

public class ProfileFragment extends Fragment implements View.OnClickListener {

    ImageView img_edit;
    TextView txtViewOrders;
    Intent intent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_profile, container, false);

        txtViewOrders=v.findViewById(R.id.txtViewOrders);
        img_edit=v.findViewById(R.id.img_edit);


        img_edit.setOnClickListener(this);
        txtViewOrders.setOnClickListener(this);

        return v;
    }

    public void onResume(){
        super.onResume();
        // Set title bar
        ((BottomActivity) getActivity())
                .setActionBarTitle("My Account");

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.img_edit:
                intent=new Intent(getContext(), EditProfileActivity.class);
                startActivity(intent);
                break;

            case R.id.txtViewOrders:
                intent=new Intent(getContext(), MyOrdersActivity.class);
                startActivity(intent);
                break;
        }
    }
}