package com.example.jobgeniet1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.jobgeniet1.databinding.CompanyHelpFourthBinding;

public class CompanyFourthHelp extends Fragment {
    CompanyHelpFourthBinding binding;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding =CompanyHelpFourthBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        GetSet helpLast = new GetSet();
        binding.companyHelpBack4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(CompanyFourthHelp.this).navigate(R.id.action_companyFourthHelp_to_companyThirdHelp);
            }
        });
        binding.companyHelpNext4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(helpLast.getBoarding()==true) {
                    NavHostFragment.findNavController(CompanyFourthHelp.this).navigate(R.id.action_companyFirstHelp_to_companyAppBoard);
                }
                else if(helpLast.getContacting()==true){
                    NavHostFragment.findNavController(CompanyFourthHelp.this).navigate(R.id.action_companyFourthHelp_to_companyAppContact);
                }
                else if(helpLast.getHoming()==true){
                    NavHostFragment.findNavController(CompanyFourthHelp.this).navigate(R.id.action_companyFourthHelp_to_companyAppHome);
                }
                else{
                    NavHostFragment.findNavController(CompanyFourthHelp.this).navigate(R.id.action_companyFourthHelp_to_companyAppOptions);
                }
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}