package com.aditya.inbihar.UI;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.aditya.inbihar.R;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import meow.bottomnavigation.MeowBottomNavigation;

public class MeowBottomActivity extends AppCompatActivity {

    MeowBottomNavigation bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meow_bottom);

        bottomNavigation =findViewById(R.id.bottom_bar);
        bottomNavigation.add(new MeowBottomNavigation.Model(1,R.drawable.ic_home));
        bottomNavigation.add(new MeowBottomNavigation.Model(2,R.drawable.ic_home));
        bottomNavigation.add(new MeowBottomNavigation.Model(3,R.drawable.ic_profile));

        bottomNavigation.setOnClickMenuListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {
                Log.d("YourResponse","model--"+model);
                return null;
            }
        });
    }

}