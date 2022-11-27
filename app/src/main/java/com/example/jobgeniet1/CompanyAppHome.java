package com.example.jobgeniet1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.jobgeniet1.databinding.CompanyAppHomeBinding;

public class CompanyAppHome extends Fragment {
    CompanyAppHomeBinding binding;
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding =CompanyAppHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        GetSet homer = new GetSet();
        binding.CompanyBoard2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(CompanyAppHome.this).navigate(R.id.action_companyAppHome_to_companyAppBoard);
            }
        });
        binding.CompanyContact2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(CompanyAppHome.this).navigate(R.id.action_companyAppHome_to_companyAppContact);
            }
        });
        binding.CompanyOptions2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(CompanyAppHome.this).navigate(R.id.action_companyAppHome_to_companyAppOptions);
            }
        });
        binding.help2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homer.SetHoming(true);
                NavHostFragment.findNavController(CompanyAppHome.this).navigate(R.id.action_companyAppHome_to_companyFirstHelp);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
