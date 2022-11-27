package com.example.jobgeniet1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.jobgeniet1.databinding.CompanyAppBoardBinding;

public class CompanyAppBoard extends Fragment {
    private CompanyAppBoardBinding binding;
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding =CompanyAppBoardBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        GetSet boarder = new GetSet();
        boarder.SetBoarding(false);
        binding.CompanyContact3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(CompanyAppBoard.this).navigate(R.id.action_companyAppBoard_to_companyAppContact);
            }
        });
        binding.CompanyHome3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(CompanyAppBoard.this).navigate(R.id.action_companyAppBoard_to_companyAppHome);
            }
        });
        binding.CompanyOptions3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(CompanyAppBoard.this).navigate(R.id.action_companyAppBoard_to_companyAppOptions);
            }
        });
        binding.help3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boarder.SetBoarding(true);
                NavHostFragment.findNavController(CompanyAppBoard.this).navigate(R.id.action_companyAppBoard_to_companyFirstHelp);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
