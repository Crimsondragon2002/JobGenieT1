package com.example.jobgeniet1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.jobgeniet1.databinding.StudentAppHomeBinding;

public class StudentAppHome extends Fragment {
    StudentAppHomeBinding binding;
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = StudentAppHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        GetSet Homer = new GetSet();
        Homer.SetHoming(false);
        binding.StudentBoard3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(StudentAppHome.this).navigate(R.id.action_studentAppHome_to_studentAppBoard);
            }
        });
        binding.StudentContact3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(StudentAppHome.this).navigate(R.id.action_studentAppHome_to_studentAppContact);
            }
        });
        binding.StudentOption3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(StudentAppHome.this).navigate(R.id.action_studentAppHome_to_studentAppOptions);
            }
        });
        binding.Studenthelp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Homer.SetHoming(true);
                NavHostFragment.findNavController(StudentAppHome.this).navigate(R.id.action_studentAppHome_to_studentFirstHelp);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
