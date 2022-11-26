package com.example.jobgeniet1;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.jobgeniet1.databinding.ActivityLoginBinding;


public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        final EditText usernameEditText = binding.username;
        final EditText passwordEditText = binding.password;
        final Button loginButton = binding.login;
        DBhelper Dat = new DBhelper(getApplicationContext());
        EditText e1,e2;
        e1 =(EditText) findViewById(R.id.username);
        e2 =(EditText) findViewById(R.id.password);
        final ProgressBar loadingProgressBar = binding.loading;
        binding.login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = e1.getText().toString();
                String pass = e1.getText().toString();
                Boolean checkUser = Dat.checkUsernameAndPassword(user,pass);
                Boolean checkType = Dat.checkUserType(user);
                if(e1.equals("")||e2.equals("")){
                    Toast.makeText(getApplicationContext(),"A field is empty",Toast.LENGTH_LONG);
                }
                else if(checkUser == false){
                    Toast.makeText(getApplicationContext(),"Username or password is incorrect",Toast.LENGTH_LONG);
                }
                else{
                    if(checkType == true){

                    }
                    else{

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



