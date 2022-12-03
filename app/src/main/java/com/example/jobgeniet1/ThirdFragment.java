package com.example.jobgeniet1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;


import com.example.jobgeniet1.databinding.FragmentThirdBinding;

public class ThirdFragment extends Fragment {
    public static String userFind;
    public static String passFind;
    private FragmentThirdBinding binding;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentThirdBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.getId();
        super.onViewCreated(view, savedInstanceState);
        EditText CompanyName = (EditText) view.findViewById(R.id.editTextCompanyName);

        EditText CompanySalary = (EditText) view.findViewById(R.id.editTextCompanySalary);
        EditText CompanyInternational = (EditText) view.findViewById(R.id.editTextCompanyInternational);
        EditText CompanyUsername = (EditText) view.findViewById(R.id.editTextCompanyUsername);
        EditText CompanyPassword = (EditText) view.findViewById(R.id.editTextStudentPassword);
        EditText CompanySkills = (EditText) view.findViewById(R.id.editTextStudentSkills);


        DBhelper Dat = new DBhelper(getContext().getApplicationContext());
        binding.thirdPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(ThirdFragment.this)
                        .navigate(R.id.action_ThirdFragment_to_FirstFragment);
            }
        });
        binding.thirdNext.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {
                String name = CompanyName.getText().toString();

                String salary = CompanySalary.getText().toString();
                int savedSalary = tryParse(salary);
                String international = CompanyInternational.getText().toString();
                String user = CompanyUsername.getText().toString();
                userFind = user;
                String pass = CompanyPassword.getText().toString();
                passFind=pass;
                String skills = CompanySkills.getText().toString();

                if(name.equals("") || salary.equals("") || international.equals("") || user.equals("") || pass.equals("") || skills.equals("")) {
                    Toast.makeText(getContext(), "A field is empty", Toast.LENGTH_SHORT).show();
                }
                else if(savedSalary == -1){
                    Toast.makeText(getContext(), "Salary and Age should be integers", Toast.LENGTH_SHORT).show();
                }
                else{
                    Boolean try1 = Dat.insertData(name,skills,savedSalary,international,0);
                    Boolean try2 = Dat.insertSecurity(user, pass,0);
                    if(try1==true && try2 == true){
                        Log.i("sighting","definitely sees the username and password");
                    }
                    if(try1 == false || try2 == false){
                        if(try1==false && try2 == false){
                            Log.i("error","both tries failed");
                        }
                        else if(try1 == false){
                            Log.i("error","try1 failed");
                        }
                        else{
                            Log.i("error","try2 failed");
                        }
                    }
                    else {
                        if(Dat.checkUsernameAndPassword(user,pass)==false){
                            if(Dat.checkUser(user)==false){
                                Log.i("error","username is incorrect");
                            }
                            if(Dat.checkPassword(pass)==false){
                                Log.i("error","password is incorrect");
                            }
                        }
                        else {
                            Intent login = new Intent(getActivity(), LoginActivity.class);
                            startActivity(login);
                        }
                    }
                }



            }
        });


    }
    public Integer tryParse(Object obj) {
        Integer retVal;
        try {
            retVal = Integer.parseInt((String) obj);
        } catch (NumberFormatException nfe) {
            retVal = -1; // or null if that is your preference
        }
        return retVal;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
