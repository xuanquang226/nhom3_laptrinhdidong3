package com.example.trile.storeverfinal.BuiXuanQuang.Java;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.example.trile.storeverfinal.R;


public class emailVerification extends AppCompatActivity {
    private EditText edtEmail;
    private EditText edtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.email_verification_layout_quang);

        //Process

        Intent intent = getIntent();
        intent.setClass(emailVerification.this,login.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
    }

}
