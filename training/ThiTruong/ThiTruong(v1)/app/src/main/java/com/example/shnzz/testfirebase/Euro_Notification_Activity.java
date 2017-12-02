package com.example.shnzz.testfirebase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

public class Euro_Notification_Activity extends AppCompatActivity {
    DatabaseReference mData;

    Intent intent;

    EditText edtGia, edtTT;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int date = c.get(Calendar.DATE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.euro__notification_layout);

        TextView tvTT = (TextView) findViewById(R.id.tvTitle);
        edtGia = (EditText) findViewById(R.id.edtgia);
        edtTT = (EditText) findViewById(R.id.editTinhtrang);
        btnBack = (Button) findViewById(R.id.btnBack);

        mData = FirebaseDatabase.getInstance().getReference();

        tvTT.setText("TỶ GIÁ NGÀY " + (date + 1)+ "/ " + (month + 1 ) + "/ " + year );

        mData.child("EURO").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                edtGia.setText(dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        /*intent = getIntent();
        String tbtang =  intent.getStringExtra("ss");
        String tbgiam = intent.getStringExtra("dd");
        if (tbtang == null)
        {
            edtTT.setText(tbgiam);
        }
        else
        {
            edtTT.setText(tb);
        }*/


        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.setClass(Euro_Notification_Activity.this,firebase.class);
                startActivity(intent);
            }
        });


        /*edtGia.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (Euro == null) {
                    return;
                } else {
                    EuroChange = edtGia.getText().toString().trim();

                    if (Integer.parseInt(EuroChange) > Integer.parseInt(Euro)) {
                        int ChangeUp = Integer.parseInt(EuroChange) - Integer.parseInt(Euro);
                        Double PercentUp = (ChangeUp * 1.0 / (Integer.parseInt(Euro) * 1.0) * 100);
                        Intent intent = getIntent();
                        Toast.makeText(Euro_Notification_Activity.this,intent.getStringExtra("Thongbao"),Toast.LENGTH_SHORT).show();
                        edtTT.setText(intent.getStringExtra("Thongbao"));
                        //edtTT.setText("Giá Euro vừa tăng " + ChangeUp + " tương đương " + Math.round(PercentUp * 100) * 1.0 / 100 + " % ");

                    } else if (Integer.parseInt(EuroChange) < Integer.parseInt(Euro)) {
                        int ChangeDown = Integer.parseInt(Euro) - Integer.parseInt(EuroChange);
                        Double PercentDown = (ChangeDown * 1.0 / (Integer.parseInt(Euro) * 1.0) * 100);
                        edtTT.setText("Giá Euro vừa giảm " + ChangeDown + " tương đương " + Math.round(PercentDown * 100) * 1.0 / 100 + " % ");
                    }
                }
            }
        });*/
    }
}




