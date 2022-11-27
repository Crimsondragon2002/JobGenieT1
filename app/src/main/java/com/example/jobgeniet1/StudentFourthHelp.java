package com.example.jobgeniet1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.jobgeniet1.databinding.StudentHelpFourthBinding;

public class StudentFourthHelp extends Fragment {
    StudentHelpFourthBinding binding;
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = StudentHelpFourthBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        GetSet HereLast = new GetSet();
        binding.studentHelpBack4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(StudentFourthHelp.this).navigate(R.id.action_companyFourthHelp_to_companyThirdHelp);
            }
        });
        binding.studentHelpNext4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(HereLast.getBoarding()==true){
                    NavHostFragment.findNavController(StudentFourthHelp.this).navigate(R.id.action_studentFourthHelp_to_studentAppBoard);
                }
                else if(HereLast.getContacting()==true){
                    NavHostFragment.findNavController(StudentFourthHelp.this).navigate(R.id.action_studentFourthHelp_to_studentAppContact);
                }
                else if(HereLast.getHoming()==true){
                    NavHostFragment.findNavController(StudentFourthHelp.this).navigate(R.id.action_studentFourthHelp_to_studentAppHome);
                }
                else {
                    NavHostFragment.findNavController(StudentFourthHelp.this).navigate(R.id.action_studentFourthHelp_to_studentAppOptions);
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
