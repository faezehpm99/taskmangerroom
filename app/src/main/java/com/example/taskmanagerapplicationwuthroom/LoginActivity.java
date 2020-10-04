package com.example.taskmanagerapplicationwuthroom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.taskmanagerapplicationwuthroom.R;

public class LoginActivity extends AppCompatActivity {
private EditText username,password;
private Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username=findViewById(R.id.loginUserId);
        password=findViewById(R.id.loginPassword);
        login=findViewById(R.id.loginpage);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userDataBase userDataBase= com.example.taskmanagerapplicationwuthroom.userDataBase.getUserDatabase(getApplicationContext());
                final userDAO userDAO=userDataBase.userDAO();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        UserEntity userEntity = userDAO.login(username.getText().toString(), login.getText().toString());
                        if (userEntity == null) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(getApplicationContext(), "Invailid", Toast.LENGTH_SHORT).show();

                                }
                            });
                        } else {
                            /*startActivity(new Intent(LoginActivity.this, ));*/
                        }


                    }

                }).start();

            }
        });
    }
}