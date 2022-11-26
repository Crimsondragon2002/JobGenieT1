package com.example.jobgeniet1;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.jobgeniet1.databinding.CompanyAppMainBinding;
import com.example.jobgeniet1.databinding.StudentAppMainBinding;

public class CompanyAppActivity extends AppCompatActivity {
    private CompanyAppMainBinding binding;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = CompanyAppMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        NavController navController = Navigation.findNavController(this, R.id.company_nav_host_fragment_content_main);
    }


}
