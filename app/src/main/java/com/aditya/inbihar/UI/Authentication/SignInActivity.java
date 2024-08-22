package com.aditya.inbihar.UI.Authentication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.aditya.inbihar.R;

public class SignInActivity extends AppCompatActivity {

    Button signin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        setContentView(R.layout.activity_sign_in);

        signin=findViewById(R.id.btn_signin);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignInActivity.this, LoginActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.nothing, R.anim.bottom_down);
                finish();
            }
        });
    }
}