package com.example.trile.storeverfinal.BuiXuanQuang.Java;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.trile.storeverfinal.MainActivity;
import com.example.trile.storeverfinal.R;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class register extends AppCompatActivity {
    private EditText edtEmailR, edtPassWordR;
    private Button btnSignUpR;
    private TextView txtHome;
    private FirebaseAuth mAuth;
    private ProgressDialog mProgress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout_quang);

        //Get FireBasae
        mAuth = FirebaseAuth.getInstance();


        //Progressbar
        mProgress = new ProgressDialog(this);
        mProgress.setTitle("Đang tạo tài khoản");
        mProgress.setMessage("Xin vui lòng chờ");

        //Ini
        edtEmailR = (EditText) findViewById(R.id.edtUserNameR);
        edtPassWordR = (EditText) findViewById(R.id.edtPassWordR);
        btnSignUpR = (Button) findViewById(R.id.btnRegister);
        txtHome = (TextView) findViewById(R.id.txtHome2);

        //Process

        txtHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(register.this, MainActivity.class));
            }
        });

        btnSignUpR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = edtEmailR.getText().toString().trim();
                String password = edtPassWordR.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Nhập email", Toast.LENGTH_SHORT).show();
                    return;
                } else if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Nhập password", Toast.LENGTH_SHORT).show();
                    return;
                } else if (password.length() < 10 || password.length() > 30) {
                    Toast.makeText(getApplicationContext(), "Nhập lại password", Toast.LENGTH_SHORT).show();
                    return;
                } else  {
                    mProgress.show();
                }

                //Create user
                mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(register.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (!task.isSuccessful()) {
                            mProgress.dismiss();
                            Toast.makeText(register.this, "Tạo tài khoản thất bại",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(register.this, "Tạo tài khoản thành công", Toast.LENGTH_SHORT).show();
                            sendEmailVerification();
                            startActivity(new Intent(register.this, login_home.class));
                        }
                    }
                });
            }
        });
    }

    private void sendEmailVerification() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            user.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(register.this, "Kiểm tra hộp thư của bạn mail xác nhận đăng ký", Toast.LENGTH_SHORT).show();
                        mProgress.dismiss();
                        mAuth.signOut();
                    }
                }
            });
        }
    }
}
