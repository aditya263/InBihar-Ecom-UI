package com.aditya.inbihar.UI.Authentication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.aditya.inbihar.R;
import com.aditya.inbihar.UI.BottomActivity;

public class LoginActivity extends AppCompatActivity {

    Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        setContentView(R.layout.activity_login);

        btn_login=findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this, BottomActivity.class);
                startActivity(intent);
            }
        });
    }

    public void OpenSignupPage(View view) {
        startActivity(new Intent(LoginActivity.this,SignInActivity.class));
        overridePendingTransition(R.anim.bottom_up, R.anim.nothing);
        finish();
    }

}