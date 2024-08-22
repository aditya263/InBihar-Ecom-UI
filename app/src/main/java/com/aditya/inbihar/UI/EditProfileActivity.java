package com.aditya.inbihar.UI;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.aditya.inbihar.R;

import java.util.Objects;

public class EditProfileActivity extends AppCompatActivity implements View.OnClickListener {

    TextView txtChangePassword,txtor;
    RelativeLayout rlBoyImage,rlGirlImage;
    ImageView imgMalePhoto,imgFemalePhoto;
    LinearLayout llMaleEdit,llFemaleEdit;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        Objects.requireNonNull(getSupportActionBar()).setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.toolbar_tiltlecenter);
        View view = getSupportActionBar().getCustomView();

        TextView title = view.findViewById(R.id.title);
        title.setText("Edit Profile");

        ImageView imageButton = (ImageView) view.findViewById(R.id.back);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        txtChangePassword=findViewById(R.id.txtChangePassword);
        txtor=findViewById(R.id.txtor);
        rlBoyImage=findViewById(R.id.rlBoyImage);
        rlGirlImage=findViewById(R.id.rlGirlImage);
        imgMalePhoto=findViewById(R.id.imgMalePhoto);
        imgFemalePhoto=findViewById(R.id.imgFemalePhoto);
        llMaleEdit=findViewById(R.id.llMaleEdit);
        llFemaleEdit=findViewById(R.id.llFemaleEdit);

        txtChangePassword.setOnClickListener(this);
        rlBoyImage.setOnClickListener(this);
        rlGirlImage.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.txtChangePassword:
                Intent intent=new Intent(EditProfileActivity.this,ChangePasswordActivity.class);
                startActivity(intent);
                break;

            case R.id.rlBoyImage:
                if (count==0){
                    count = 1;
                    llMaleEdit.setVisibility(View.GONE);
                    txtor.setVisibility(View.VISIBLE);
                    rlGirlImage.setVisibility(View.VISIBLE);
                    llFemaleEdit.setVisibility(View.GONE);
                }else if (count==1){
                    count = 0;
                    llMaleEdit.setVisibility(View.VISIBLE);
                    txtor.setVisibility(View.GONE);
                    rlGirlImage.setVisibility(View.GONE);
                    llFemaleEdit.setVisibility(View.GONE);
                }
                break;

            case R.id.rlGirlImage:
                if (count==0){
                    count = 1;
                    llFemaleEdit.setVisibility(View.GONE);
                    txtor.setVisibility(View.VISIBLE);
                    rlBoyImage.setVisibility(View.VISIBLE);
                    llMaleEdit.setVisibility(View.GONE);
                }else if (count==1){
                    count = 0;
                    llFemaleEdit.setVisibility(View.VISIBLE);
                    txtor.setVisibility(View.GONE);
                    rlBoyImage.setVisibility(View.GONE);
                    llMaleEdit.setVisibility(View.GONE);
                }
                break;
        }
    }
}