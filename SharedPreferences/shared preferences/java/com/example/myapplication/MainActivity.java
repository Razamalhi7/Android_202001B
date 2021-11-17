package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText txtUsername,txtPassword;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtUsername=findViewById(R.id.username);
        txtPassword=findViewById(R.id.password);
        sharedPreferences=getSharedPreferences("Login",MODE_PRIVATE);

        String username=sharedPreferences.getString("UserName","");
        String password=sharedPreferences.getString("Password","");

        txtUsername.setText(username);
        txtPassword.setText(password);

    }
    public void btn_login(View view)
    {
        SharedPreferences.Editor editor= sharedPreferences.edit();
        String username=txtUsername.getText().toString();
        String password=txtPassword.getText().toString();

        editor.putString("UserName",username);
        editor.putString("Password",password);
        editor.commit();
        Intent intent =new Intent(this,HomeActivity.class);
        startActivity(intent);

    }
}