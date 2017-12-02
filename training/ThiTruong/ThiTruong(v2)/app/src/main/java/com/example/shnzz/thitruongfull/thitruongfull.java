package com.example.shnzz.thitruongfull;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class thitruongfull extends AppCompatActivity {
    DatabaseReference mData;
    EditText vang9999, vang24k, USD, SGD;
    Button btnXembd;
    String gold24k, gold24change;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thitruongfull_layout);
        mData = FirebaseDatabase.getInstance().getReference();
        anhXa();
        loaddata();
        notification();
        btnXembd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thitruongfull.this, ChartActivity.class);
                startActivity(intent);
            }
        });

    }

    public void anhXa() {
        vang9999 = (EditText) findViewById(R.id.edtvang9999);
        vang24k = (EditText) findViewById(R.id.edt24k);
        USD = (EditText) findViewById(R.id.edtUSD);
        SGD = (EditText) findViewById(R.id.edtSGD);
        btnXembd = (Button) findViewById(R.id.btnxembieudo);
    }

    public void loaddata() {
        mData.child("vang9999").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                vang9999.setText(dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        mData.child("24k_chunhat").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                vang24k.setText(dataSnapshot.getValue().toString());
                gold24k = dataSnapshot.getValue().toString();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        mData.child("USD").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                USD.setText(dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        mData.child("SGD").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                SGD.setText(dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void notification() {
        vang24k.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (gold24k == null) {
                    return;
                } else {
                    gold24change = vang24k.getText().toString().trim();

                    if (Integer.parseInt(gold24change) > Integer.parseInt(gold24k)) {
                        int ChangeUp = Integer.parseInt(gold24change) - Integer.parseInt(gold24k);
                        Double PercentUp = (ChangeUp * 1.0 / (Integer.parseInt(gold24k) * 1.0) * 100);
                        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                        Notification.Builder builder = new Notification.Builder(thitruongfull.this);
                        builder.setContentTitle("Tin mới từ Thị Trường");
                        builder.setContentText("Giá vàng 24k vừa tăng " + ChangeUp + " tương đương " + Math.round(PercentUp * 100) * 1.0 / 100 + " % ");
                        builder.setSmallIcon(R.drawable.gold);
                        notificationManager.notify(1, builder.build());

                    } else if (Integer.parseInt(gold24change) < Integer.parseInt(gold24k)) {
                        int ChangeDown = Integer.parseInt(gold24k) - Integer.parseInt(gold24change);
                        Double PercentDown = (ChangeDown * 1.0 / (Integer.parseInt(gold24k) * 1.0) * 100);
                        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                        Notification.Builder builder = new Notification.Builder(thitruongfull.this);
                        builder.setContentTitle("Tin mới từ Thị Trường");
                        builder.setContentText("Giá vàng 24k vừa giảm " + ChangeDown + " tương đương " + Math.round(PercentDown * 100) * 1.0 / 100 + " % ");
                        builder.setSmallIcon(R.drawable.gold);
                        notificationManager.notify(1, builder.build());
                    }

                }
            }
        });
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }
}
