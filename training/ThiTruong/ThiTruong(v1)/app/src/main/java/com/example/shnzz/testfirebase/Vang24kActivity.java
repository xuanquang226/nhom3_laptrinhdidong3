package com.example.shnzz.testfirebase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;

public class Vang24kActivity extends AppCompatActivity {
    DatabaseReference mData;

    Intent intent;

    EditText edtGia, edtTT;
    Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vang24k_layout);

        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int date = c.get(Calendar.DATE);

        TextView tvTT = (TextView) findViewById(R.id.tvTitle);
        edtGia = (EditText) findViewById(R.id.edtgia);
        edtTT = (EditText) findViewById(R.id.editTinhtrang);
        btnBack = (Button) findViewById(R.id.btnBack);

        mData = FirebaseDatabase.getInstance().getReference();

        mData.child("Vàng 24k").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                edtGia.setText(dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        intent = getIntent();
        //String tb =  intent.getStringExtra("ss");
        //edtTT.setText(tb);

        tvTT.setText("TỶ GIÁ NGÀY " + (date + 1)+ "/ " + (month + 1 ) + "/ " + year );
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.setClass(Vang24kActivity.this,firebase.class);
                startActivity(intent);
            }
        });
    }
}
