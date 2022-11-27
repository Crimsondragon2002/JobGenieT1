package com.example.jobgeniet1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.jobgeniet1.databinding.StudentHelpFirstBinding;

public class StudentFirstHelp extends Fragment {
    StudentHelpFirstBinding binding;
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = StudentHelpFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        GetSet HereFirst = new GetSet();
        binding.studentHelpBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(HereFirst.getBoarding()== true){
                    NavHostFragment.findNavController(StudentFirstHelp.this).navigate(R.id.action_studentFirstHelp_to_studentAppBoard);
                }
                else if(HereFirst.getContacting()== true){
                    NavHostFragment.findNavController(StudentFirstHelp.this).navigate(R.id.action_studentFirstHelp_to_studentAppContact);
                }
                else if(HereFirst.getHoming()== true){
                    NavHostFragment.findNavController(StudentFirstHelp.this).navigate(R.id.action_studentFirstHelp_to_studentAppHome);
                }
                else {
                    NavHostFragment.findNavController(StudentFirstHelp.this).navigate(R.id.action_studentFirstHelp_to_studentAppOptions);
                }
            }
        });
        binding.studentHelpNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(StudentFirstHelp.this).navigate(R.id.action_studentFirstHelp_to_studentSecondHelp);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
