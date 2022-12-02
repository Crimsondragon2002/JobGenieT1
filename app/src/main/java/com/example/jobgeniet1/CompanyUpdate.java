package com.example.jobgeniet1;

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

import com.example.jobgeniet1.databinding.CompanyUpdateBinding;

public class CompanyUpdate  extends Fragment {
    private CompanyUpdateBinding binding;
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = CompanyUpdateBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        CompanyLogin logging = new CompanyLogin();
        String oldUser = logging.getUserFind();
        String oldname = logging.getNameFind();
        view.getId();
        super.onViewCreated(view, savedInstanceState);
        EditText CompanyName = (EditText) view.findViewById(R.id.editTextCompanyName);

        EditText CompanySalary = (EditText) view.findViewById(R.id.editTextCompanySalary);
        EditText CompanyInternational = (EditText) view.findViewById(R.id.editTextCompanyInternational);
        EditText CompanyUsername = (EditText) view.findViewById(R.id.editTextCompanyUsername);
        EditText CompanyPassword = (EditText) view.findViewById(R.id.editTextCompanyPassword);
        EditText CompanySkills = (EditText) view.findViewById(R.id.editTextCompanySkills);


        DBhelper Dat = new DBhelper(getContext().getApplicationContext());


        binding.companybuttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(CompanyUpdate.this).navigate(R.id.action_companyUpdate_to_companyLogin);
            }
        });


        binding.companybuttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = CompanyName.getText().toString();

                String salary = CompanySalary.getText().toString();
                int savedSalary = tryParse(salary);
                String international = CompanyInternational.getText().toString();
                String user = CompanyUsername.getText().toString();
                String pass = CompanyPassword.getText().toString();

                String skills = CompanySkills.getText().toString();

                if(name.equals("") || salary.equals("") || international.equals("") || user.equals("") || pass.equals("") || skills.equals("")) {
                    Toast.makeText(getContext(), "A field is empty", Toast.LENGTH_SHORT).show();
                }
                else if(savedSalary == -1){
                    Toast.makeText(getContext(), "Salary and Age should be integers", Toast.LENGTH_SHORT).show();
                }
                else{
                    Boolean try1 = Dat.updateData(oldname,name,skills,savedSalary,international,0);
                    Boolean try2 = Dat.updateSecurity(oldUser,user, pass,0);
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
                            NavHostFragment.findNavController(CompanyUpdate.this).navigate(R.id.action_companyUpdate_to_companyAppOptions);
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
