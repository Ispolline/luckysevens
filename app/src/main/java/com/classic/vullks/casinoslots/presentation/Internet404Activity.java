package com.classic.vullks.casinoslots.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.classic.vullks.casinoslots.R;

public class Internet404Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internet404);
        initView();
    }

    private void initView() {
        Button mBtnCheckInternet = findViewById(R.id.btn_check_internet);
        mBtnCheckInternet.setOnClickListener(v -> {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        });
    }
}