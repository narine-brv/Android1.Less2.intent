package com.narine.android1less2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView imageCamera;
    ImageView imageContacts;
    ImageView imageSearch;

    Button btn;
    TextView tvInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        listeners();
    }

    public void initView(){
        imageCamera = findViewById(R.id.img_camera);
        imageContacts = findViewById(R.id.img_contacts);
        imageSearch = findViewById(R.id.img_search);
        btn = findViewById(R.id.btn);
        tvInfo = findViewById(R.id.tv_info);

    }

    public void listeners () {
        imageCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA); //фото
                // Intent intent = new Intent(MediaStore.INTENT_ACTION_VIDEO_CAMERA);  //видео
                // if (intent.resolveActivity(getPackageManager()) != null) {
                // startActivity(intent);}
                startActivity(intent);

            }
        });

        imageContacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = "tel: (+996) 555 555 555";
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(phoneNumber)); //контакты
                startActivity(intent);
            }
        });

        imageSearch.setOnClickListener(new View.OnClickListener() { //поиск в гугле
            @Override
            public void onClick(View v) {
                String query = "Кино для детей";
                Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY, query);
                startActivity(intent);
            }
        });

        // сообщения
//                Intent intent = new Intent();
//                intent.putExtra(Intent.EXTRA_TEXT, "GeekTech");
//                intent.setAction(Intent.ACTION_SEND);
//                intent.setType("text/plain");

        tvInfo.setOnClickListener(new View.OnClickListener() { //мы отправили в 3е активити инфу,
            // нам надо отправить туда данные которые прописаны по ключу key_text
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
                intent.putExtra("key_text","Here third Activity");
                startActivity (intent);
            }
        });

        //Intent intent = new Intent(MainActivity.this, NextActivity.class); явный интент
        //startActivity (intent);

        btn.setOnClickListener(new View.OnClickListener() { //интент на результат
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivityForResult(intent, 105);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data); //requestCode это 105 уникальный код

        if (requestCode == 105) {

            if (resultCode == RESULT_OK) {
                String text = data.getStringExtra("key3");
                tvInfo.setText(text);
            }
        }
    }
}