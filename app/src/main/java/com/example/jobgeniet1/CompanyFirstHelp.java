package com.example.jobgeniet1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.jobgeniet1.databinding.CompanyHelpFirstBinding;

public class CompanyFirstHelp extends Fragment {
    private CompanyHelpFirstBinding binding;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding =CompanyHelpFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        GetSet helpFirst = new GetSet();
        binding.companyHelpBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(helpFirst.getBoarding()==true){
                    NavHostFragment.findNavController(CompanyFirstHelp.this).navigate(R.id.action_companyFirstHelp_to_companyAppBoard);
                }
                else if(helpFirst.getContacting()==true){
                    NavHostFragment.findNavController(CompanyFirstHelp.this).navigate(R.id.action_companyFirstHelp_to_companyAppContact);
                }
                else if(helpFirst.getHoming()==true){
                    NavHostFragment.findNavController(CompanyFirstHelp.this).navigate(R.id.action_companyFirstHelp_to_companyAppHome);
                }
                else{
                    NavHostFragment.findNavController(CompanyFirstHelp.this).navigate(R.id.action_companyFirstHelp_to_companyAppOptions);
                }
            }
        });
       binding.companyHelpNext.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               NavHostFragment.findNavController(CompanyFirstHelp.this).navigate(R.id.action_companyFirstHelp_to_companySecondHelp);
           }
       });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
