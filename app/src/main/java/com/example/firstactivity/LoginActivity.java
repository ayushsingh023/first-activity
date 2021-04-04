package com.example.firstactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    EditText uid,pass;
    Button login;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        uid=findViewById(R.id.uid);
        pass=findViewById(R.id.pass);
        login=findViewById(R.id.login);
        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String user=uid.getText().toString();
        String password=pass.getText().toString();
        if (user.equals(password))
        {
            sp=getSharedPreferences("myeictpref",MODE_PRIVATE);
            SharedPreferences.Editor se=sp.edit();
            se.putBoolean("isLogin",true);
            se.commit();
            Intent intent=new Intent(LoginActivity.this,MyMenu.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(this, "INVALID USER/PASSWORD", Toast.LENGTH_SHORT).show();
        }

    }
}