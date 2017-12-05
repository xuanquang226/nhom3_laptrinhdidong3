package com.example.trile.storeverfinal.BuiXuanQuang.Java;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.trile.storeverfinal.MainActivity;
import com.example.trile.storeverfinal.R;

public class login_home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_home_layout_quang);

        //Init
        Button btnSignIn = (Button) findViewById(R.id.btnSignInH);
        Button btnSignUp = (Button) findViewById(R.id.btnSignUpH);
        TextView txtHome = (TextView) findViewById(R.id.txtHome);


        //Process
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(login_home.this, login.class));
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(login_home.this, register.class));
            }
        });

        txtHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(login_home.this, MainActivity.class));
            }
        });

    }

}
