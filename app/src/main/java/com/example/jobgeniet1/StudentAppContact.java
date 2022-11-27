package com.example.jobgeniet1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.jobgeniet1.databinding.StudentAppContactBinding;

public class StudentAppContact extends Fragment {
    private StudentAppContactBinding binding;
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = StudentAppContactBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        GetSet Contacter = new GetSet();
        Contacter.SetContacting(false);
        binding.StudentBoard2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(StudentAppContact.this).navigate(R.id.action_studentAppContact_to_studentAppBoard);
            }
        });
        binding.StudentHome2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(StudentAppContact.this).navigate(R.id.action_studentAppContact_to_studentAppHome);
            }
        });
        binding.StudentOption2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(StudentAppContact.this).navigate(R.id.action_studentAppContact_to_studentAppOptions);
            }
        });
        binding.Studenthelp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Contacter.SetContacting(true);
                NavHostFragment.findNavController(StudentAppContact.this).navigate(R.id.action_studentAppContact_to_studentFirstHelp);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
