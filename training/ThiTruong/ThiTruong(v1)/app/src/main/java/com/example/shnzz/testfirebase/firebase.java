package com.example.shnzz.testfirebase;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class firebase extends AppCompatActivity {
    DatabaseReference mData;
    Intent intent;
    Switch sw;

    EditText edt24k;
    EditText edt9999;
    EditText edtSJC;

    EditText edtEURO;
    EditText edtSGD;
    EditText edtUSD;

    Button btnLuu;

    String Euro, EuroChange;

    String Sgd, SgdChange, Usd, UsdChange, vang9999, vang9999Change, vang24k, vang24kChange, vangSJC, vangSJCCHange;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firebase_layout);
        anhXa();
        loadData()  ;
        ThongBaoChange();

        /*Sgd = Double.parseDouble(edtSGD.getText().toString());
        Usd = Double.parseDouble(edtUSD.getText().toString());
        vang24k = Double.parseDouble(edt24k.getText().toString());
        vang9999 = Double.parseDouble(edt9999.getText().toString());
        vangSJC = Double.parseDouble(edtSJC.getText().toString());*/

        /*sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (sw.isChecked()) {
                    btnLuu.setEnabled(true);
                    enableAllEdt();
                } else {
                    mData.child("Vàng 24k").setValue(edt24k.getText().toString());
                    mData.child("Vàng 9999").setValue(edt9999.getText().toString());
                    mData.child("Vàng SJC").setValue(edtSJC.getText().toString());
                    mData.child("EURO").setValue(edtEURO.getText().toString());
                    mData.child("SINGAPORE DOLLAR").setValue(edtSGD.getText().toString());
                    mData.child("US DOLLAR").setValue(edtUSD.getText().toString());
                    btnLuu.setEnabled(false);
                    disableAllEdt();
                    Toast toast = Toast.makeText(firebase.this, "Lưu thành công !", Toast.LENGTH_SHORT);
                    toast.show();

                }
            }
        });*/

        /*btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mData.child("Vàng 24k").setValue(edt24k.getText().toString());
                mData.child("Vàng 9999").setValue(edt9999.getText().toString());
                mData.child("Vàng SJC").setValue(edtSJC.getText().toString());
                mData.child("EURO").setValue(edtEURO.getText().toString());
                mData.child("SINGAPORE DOLLAR").setValue(edtSGD.getText().toString());
                mData.child("US DOLLAR").setValue(edtUSD.getText().toString());
                sw.setChecked(false);
                btnLuu.setEnabled(false);

            }
        });*/


    }

    public void disableAllEdt() {
        edt24k.setEnabled(false);
        edt9999.setEnabled(false);
        edtEURO.setEnabled(false);
        edtSGD.setEnabled(false);
        edtSJC.setEnabled(false);
        edtUSD.setEnabled(false);
    }

    public void enableAllEdt() {
        btnLuu.setEnabled(true);
        edt24k.setEnabled(true);
        edt9999.setEnabled(true);
        edtEURO.setEnabled(true);
        edtSGD.setEnabled(true);
        edtSJC.setEnabled(true);
        edtUSD.setEnabled(true);
    }

    public void anhXa() {

        edt24k = (EditText) findViewById(R.id.edt24k);
        edt9999 = (EditText) findViewById(R.id.edt9999);
        edtSJC = (EditText) findViewById(R.id.edtSJC);

        edtEURO = (EditText) findViewById(R.id.edtEURO);
        edtSGD = (EditText) findViewById(R.id.edtSGD);
        edtUSD = (EditText) findViewById(R.id.edtUSDD);
    }

    public void loadData() {
        mData = FirebaseDatabase.getInstance().getReference();

        mData.child("Vàng 24k").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                edt24k.setText(dataSnapshot.getValue().toString());
                vang24k = dataSnapshot.getValue().toString();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        mData.child("Vàng 9999").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                edt9999.setText(dataSnapshot.getValue().toString());
                vang9999 = dataSnapshot.getValue().toString();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        mData.child("Vàng SJC").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                edtSJC.setText(dataSnapshot.getValue().toString());
                vangSJC = dataSnapshot.getValue().toString();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        mData.child("EURO").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                edtEURO.setText(dataSnapshot.getValue().toString());
                Euro = dataSnapshot.getValue().toString();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        mData.child("SINGAPORE DOLLAR").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                edtSGD.setText(dataSnapshot.getValue().toString());
                Sgd = dataSnapshot.getValue().toString();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        mData.child("US DOLLAR").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                edtUSD.setText(dataSnapshot.getValue().toString());
                Usd = dataSnapshot.getValue().toString();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void ThongBaoChange() {
        edtEURO.addTextChangedListener(new TextWatcher() {
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
                    EuroChange = edtEURO.getText().toString().trim();

                    if (Integer.parseInt(EuroChange) > Integer.parseInt(Euro)) {
                        int ChangeUp = Integer.parseInt(EuroChange) - Integer.parseInt(Euro);
                        Double PercentUp = (ChangeUp * 1.0 / (Integer.parseInt(Euro) * 1.0) * 100);
                        intent = new Intent(firebase.this, Euro_Notification_Activity.class);
                        PendingIntent pendingIntent = PendingIntent.getActivity(firebase.this, 1, intent, 0);
                        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                        Notification.Builder builder = new Notification.Builder(firebase.this);
                        builder.setContentTitle("Tin mới từ Thị Trường");
                        builder.setContentText("Giá Euro vừa tăng " + ChangeUp + " tương đương " + Math.round(PercentUp * 100) * 1.0 / 100 + " % ");
                        builder.setSmallIcon(R.drawable.gold);
                        builder.setContentIntent(pendingIntent);
                        notificationManager.notify(1, builder.build());

                    } else if (Integer.parseInt(EuroChange) < Integer.parseInt(Euro)) {
                        int ChangeDown = Integer.parseInt(Euro) - Integer.parseInt(EuroChange);
                        Double PercentDown = (ChangeDown * 1.0 / (Integer.parseInt(Euro) * 1.0) * 100);
                        intent = new Intent(firebase.this, Euro_Notification_Activity.class);
                        PendingIntent pendingIntent = PendingIntent.getActivity(firebase.this, 1, intent, 0);
                        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                        Notification.Builder builder = new Notification.Builder(firebase.this);
                        builder.setContentTitle("Tin mới từ Thị Trường");
                        builder.setContentText("Giá Euro vừa giảm " + ChangeDown + " tương đương " + Math.round(PercentDown * 100) * 1.0 / 100 + " % ");
                        builder.setSmallIcon(R.drawable.gold);
                        builder.setContentIntent(pendingIntent);


                        notificationManager.notify(1, builder.build());
                    }
                }
            }
        });

        edt24k.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (vang24k == null) {
                    return;
                } else {
                    vang24kChange = edt24k.getText().toString().trim();
                    if (Integer.parseInt(vang24kChange) > Integer.parseInt(vang24k)) {
                        int ChangeUp = Integer.parseInt(vang24kChange) - Integer.parseInt(vang24k);
                        Double PercentUp = (ChangeUp * 1.0 / (Integer.parseInt(vang24k) * 1.0) * 100);
                        intent = new Intent(firebase.this, Vang24kActivity.class);

                        PendingIntent pendingIntent = PendingIntent.getActivity(firebase.this, 1, intent, 0);
                        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                        Notification.Builder builder = new Notification.Builder(firebase.this);
                        builder.setContentTitle("Tin mới từ Thị Trường");
                        builder.setContentText("Giá Vàng 24k vừa tăng " + ChangeUp + " tương đương " + Math.round(PercentUp * 100) * 1.0 / 100 + " % ");
                        builder.setSmallIcon(R.drawable.gold);
                        builder.setContentIntent(pendingIntent);
                        notificationManager.notify(1, builder.build());
                    } else if (Integer.parseInt(vang24kChange) < Integer.parseInt(vang24k)) {
                        int ChangeDown = Integer.parseInt(vang24k) - Integer.parseInt(vang24kChange);
                        Double PercentDown = (ChangeDown * 1.0 / (Integer.parseInt(vang24k) * 1.0) * 100);
                        intent = new Intent(firebase.this, Vang24kActivity.class);

                        PendingIntent pendingIntent = PendingIntent.getActivity(firebase.this, 1, intent, 0);
                        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                        Notification.Builder builder = new Notification.Builder(firebase.this);
                        builder.setContentTitle("Tin mới từ Thị Trường");
                        builder.setContentText("Giá Vàng 24k vừa giảm " + ChangeDown + " tương đương " + Math.round(PercentDown * 100) * 1.0 / 100 + " % ");
                        builder.setSmallIcon(R.drawable.gold);
                        builder.setContentIntent(pendingIntent);
                        notificationManager.notify(1, builder.build());
                    }
                }
            }
        });
    }

}
