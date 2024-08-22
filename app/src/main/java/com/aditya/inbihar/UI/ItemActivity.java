package com.aditya.inbihar.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aditya.inbihar.R;

public class ItemActivity extends AppCompatActivity {

    TextView txtActualCost;
    LinearLayout layoutItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        txtActualCost=findViewById(R.id.txtActualCost);
        layoutItem=findViewById(R.id.layoutItem);

        //Strike through the textView
        txtActualCost.setPaintFlags(txtActualCost.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

        layoutItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ItemActivity.this,ItemDetailActivity.class);
                startActivity(intent);
            }
        });
    }
}