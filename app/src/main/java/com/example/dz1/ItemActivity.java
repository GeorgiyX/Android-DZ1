package com.example.dz1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        Intent intent = getIntent();
        TextView textView = findViewById(R.id.bigText);
        textView.setText(intent.getStringExtra("NUM"));
        if (Integer.parseInt(intent.getStringExtra("NUM"))%2==0){
            textView.setTextColor(this.getResources().getColor(R.color.colorAccent));
        }
        else {
            textView.setTextColor(this.getResources().getColor(R.color.colorBlue));
        }
    }
}
