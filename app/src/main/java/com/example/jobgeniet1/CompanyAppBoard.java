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
        binding.CompanyLogOut3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent logOut= new Intent(getActivity(),LoginActivity.class);
                startActivity(logOut);
            }
        });
        TextView e1,e2,e3,e4;
        e1=(EditText) view.findViewById(R.id.companya);
        e2=(EditText) view.findViewById(R.id.companyb);
        e3=(EditText) view.findViewById(R.id.companyc);
        e4=(EditText) view.findViewById(R.id.companyd);
        Button button = view.findViewById(R.id.companyNA);
        binding.CompanyBoard3.setOnClickListener(new View.OnClickListener() {
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


        binding.companyNA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(CompanyAppBoard.this).navigate(R.id.action_companyAppBoard_to_companyAD);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
