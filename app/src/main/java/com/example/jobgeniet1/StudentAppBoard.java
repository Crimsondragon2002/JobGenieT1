package com.example.jobgeniet1;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.jobgeniet1.databinding.StudentAppBoardBinding;

public class StudentAppBoard extends Fragment {
    private StudentAppBoardBinding binding;


    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = StudentAppBoardBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        GetSet Boarder = new GetSet();
        Boarder.SetBoarding(false);
        binding.StudentContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(StudentAppBoard.this).navigate(R.id.action_studentAppBoard_to_studentAppContact);
            }
        });
        binding.StudentHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(StudentAppBoard.this).navigate(R.id.action_studentAppBoard_to_studentAppHome);
            }
        });
        binding.StudentOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(StudentAppBoard.this).navigate(R.id.action_studentAppBoard_to_studentAppOptions);
            }
        });
        binding.Studenthelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boarder.SetBoarding(true);
                NavHostFragment.findNavController(StudentAppBoard.this).navigate(R.id.action_studentAppBoard_to_studentFirstHelp);
            }
        });
        binding.StudentLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent logOut= new Intent(getActivity(),LoginActivity.class);
                startActivity(logOut);
            }
        });
        TextView e1,e2,e3,e4;
        e1=(EditText) view.findViewById(R.id.a);
        e2=(EditText) view.findViewById(R.id.b);
        e3=(EditText) view.findViewById(R.id.c);
        e4=(EditText) view.findViewById(R.id.d);
        Button button = view.findViewById(R.id.NA);
        binding.StudentBoard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                String s3 = e3.getText().toString();
                String s4 = e4.getText().toString();
                if(s1.equals("911")&&s2.equals("411")&&s3.equals("314")&&s4.equals("159")){
                    button.setEnabled(true);
                }
            }
        });


        binding.NA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(StudentAppBoard.this).navigate(R.id.action_studentAppBoard_to_studentAD);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}