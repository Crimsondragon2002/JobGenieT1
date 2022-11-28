package com.example.jobgeniet1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.jobgeniet1.databinding.ActivityLoginBinding;


public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SecondFragment secondFragment = new SecondFragment();
        final EditText usernameEditText = binding.username;
        final EditText passwordEditText = binding.password;
        final Button loginButton = binding.login;
        DBhelper Dat = new DBhelper(getApplicationContext());

        EditText e1,e2;
        e1 =(EditText) findViewById(R.id.username);
        e2 =(EditText) findViewById(R.id.password);
        binding.login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = e1.getText().toString();
                String pass = e2.getText().toString();
                Boolean Damnit = Dat.checkUser("ABC");

                Boolean checkUser = Dat.checkUsernameAndPassword(user,pass);
                Boolean checkType = Dat.checkUserType(user);

                if(e1.equals("")||e2.equals("")){
                    Toast.makeText(getApplicationContext(),"A field is empty",Toast.LENGTH_LONG);

                }
                else if(checkUser == false){
                    Toast.makeText(getApplicationContext(),"Username or password is incorrect",Toast.LENGTH_LONG);

                }
                else{
                    Log.i("sighting","should still work");
                    if(checkType == false){
                    Intent studentApp = new Intent(LoginActivity.this,StudentAppActivity.class);
                    startActivity(studentApp);
                    }
                    else{
                        Intent companyApp = new Intent(LoginActivity.this,CompanyAppActivity.class);
                        startActivity(companyApp);
                    }
                }
            }
        });

        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent signIn = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(signIn);
            }
        });
    }
}



