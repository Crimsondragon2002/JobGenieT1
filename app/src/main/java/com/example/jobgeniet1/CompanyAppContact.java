package com.example.jobgeniet1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.jobgeniet1.databinding.CompanyAppContactBinding;

public class CompanyAppContact extends Fragment {
    CompanyAppContactBinding binding;
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = CompanyAppContactBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        GetSet contacter = new GetSet();
        contacter.SetContacting(false);
        binding.CompanyBoard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(CompanyAppContact.this).navigate(R.id.action_companyAppContact_to_companyAppBoard);
            }
        });
        binding.CompanyHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(CompanyAppContact.this).navigate(R.id.action_companyAppContact_to_companyAppHome);
            }
        });
        binding.CompanyOptions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(CompanyAppContact.this).navigate(R.id.action_companyAppContact_to_companyAppOptions);
            }
        });
        binding.help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contacter.SetContacting(true);
                NavHostFragment.findNavController(CompanyAppContact.this).navigate(R.id.action_companyAppContact_to_companyFirstHelp);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
