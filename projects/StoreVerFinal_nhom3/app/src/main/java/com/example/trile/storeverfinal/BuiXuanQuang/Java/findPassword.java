package com.example.trile.storeverfinal.BuiXuanQuang.Java;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.trile.storeverfinal.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class findPassword extends AppCompatActivity {
    private EditText edtFindPass;
    private Button btnFindPass;
    private FirebaseAuth mAuth;
    private ProgressDialog mProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.find_pass_layout);

        mAuth = FirebaseAuth.getInstance();

        mProgress = new ProgressDialog(this);
        mProgress.setTitle("Đang xử lý");
        mProgress.setMessage("Vui lòng chờ");
        //Ini
        edtFindPass = (EditText) findViewById(R.id.edtFindPass);
        btnFindPass = (Button) findViewById(R.id.btnFindPass);

        btnFindPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = edtFindPass.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplication(), "Nhập email bạn đã đăng ký", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    mProgress.show();
                }

                mAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            mProgress.dismiss();
                            Toast.makeText(findPassword.this, "Bạn kiểm tra mail để đổi lại mật khẩu", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(findPassword.this, login.class));
                        } else {
                            mProgress.dismiss();
                            Toast.makeText(findPassword.this, "Mail không tồn tại", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}
