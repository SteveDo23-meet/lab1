package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    SharedPreferences sp;
    EditText etEmail , etPassword;
    Button btnSignin , btnSignup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        btnSignin = (Button) findViewById(R.id.btnSignin);
        btnSignin.setOnClickListener(this);
        btnSignup = (Button) findViewById(R.id.btnSignup);
        sp=getSharedPreferences("details1",0);
        btnSignup.setOnClickListener(this);
        String strEmail = sp.getString("Email",null);

        if(etEmail != null){
            etEmail.setText(strEmail);
        }
    }

    @Override
    public void onClick(View view) {
        if(view == btnSignin){
            SharedPreferences.Editor editor=sp.edit();
            editor.putString("Email",etEmail.getText().toString());
            editor.commit();
        }
        else{
            Toast.makeText(this,"username password saved",Toast.LENGTH_LONG).show();
        }
    }
}