package com.example.taskmanagerapplicationwuthroom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{
    private EditText userID, userName, userPassword;
    private Button register,login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userID = findViewById(R.id.UserId);
        userName = findViewById(R.id.name);
        userPassword = findViewById(R.id.password);
        register = findViewById(R.id.button);
        login=findViewById(R.id.login);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final UserEntity userEntity = new UserEntity();
                userEntity.setUserId(userID.getText().toString());
                userEntity.setPassword(userPassword.getText().toString());
                userEntity.setName(userName.getText().toString());
                    userDataBase userDataBase= com.example.taskmanagerapplicationwuthroom.userDataBase.getUserDatabase(getApplicationContext());
                    final userDAO userDAO=userDataBase.userDAO();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            userDAO.register(userEntity);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(getApplicationContext(), "sth", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    }).start();

                }


        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);

            }
        });


    }

   /* private Boolean isValid(UserEntity userEntity) {
        if (userEntity.getName().isEmpty() || userEntity.getPassword().
                isEmpty() || userEntity.getId() == null) {
            return false;
        }
        return true;

    }*/

}