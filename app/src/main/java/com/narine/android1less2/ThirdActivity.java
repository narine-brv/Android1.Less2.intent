package com.narine.android1less2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    TextView tvInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        tvInfo = findViewById(R.id.tv_info3);

        TextView textView = new TextView(this);
        textView.setTextSize(26);
        textView.setPadding(16, 16, 16, 16);

        Bundle arguments = getIntent().getExtras();
        String text3 = arguments.get("key_text").toString();
        textView.setText(text3);
        setContentView(textView);

    }
}