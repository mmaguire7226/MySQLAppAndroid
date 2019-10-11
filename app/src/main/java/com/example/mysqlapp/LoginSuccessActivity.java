package com.example.mysqlapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LoginSuccessActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_success);

        TextView txtname = (TextView) findViewById(R.id.textView_success);
        Intent intent = getIntent();
        String loginName = intent.getStringExtra("Name");
        txtname.setText("Weclome, " + loginName);

    }
    public void logOutOk(View view) {
        Intent intent = new Intent(LoginSuccessActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
