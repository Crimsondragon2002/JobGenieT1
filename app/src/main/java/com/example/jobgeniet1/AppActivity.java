package com.example.jobgeniet1;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import com.example.jobgeniet1.databinding.AppMainBinding;

public class AppActivity extends AppCompatActivity {
    private AppMainBinding binding;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = AppMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }


}
