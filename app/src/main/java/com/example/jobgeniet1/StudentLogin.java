package com.example.jobgeniet1;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.jobgeniet1.databinding.StudentLoginBinding;

public class StudentLogin extends Fragment {
    private static String userFind;
    private static String nameFind;
    public String getNameFind(){
        return nameFind;
    }
    public void setNameFind(String findName){
        this.nameFind = findName;
    }
    public String getUserFind(){
        return userFind;
    }
    public void setUserFind(String findUser){
        this.userFind = findUser;
    }
    StudentLoginBinding binding;
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = StudentLoginBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final EditText usernameEditText = binding.studentusername;
        final EditText passwordEditText = binding.studentpassword;
        final Button loginButton = binding.studentlogin;
        DBhelper Dat = new DBhelper(getContext());

        EditText e1,e2, e3;
        e1 =(EditText) view.findViewById(R.id.username);
        e2 =(EditText) view.findViewById(R.id.password);
        e3 = (EditText) view.findViewById(R.id.oldName);
        binding.studentlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = e1.getText().toString();
                String pass = e2.getText().toString();
                String oldName = e3.getText().toString();
                Boolean checkUser = Dat.checkUsernameAndPassword(user,pass);
                Boolean checkType = Dat.checkUserType(user);
                Boolean checkName = Dat.checkName(oldName);
                if(e1.equals("")||e2.equals("")||e3.equals("")){
                    Toast.makeText(getContext(),"A field is empty",Toast.LENGTH_LONG);

                }
                else if(checkUser == false){
                    Toast.makeText(getContext(),"Username or password is incorrect",Toast.LENGTH_LONG);

                }
                else if(checkName == false){
                    Toast.makeText(getContext(),"Name is incorrect",Toast.LENGTH_LONG);
                }
                else{
                    Log.i("sighting","should still work");
                        setUserFind(user);
                        setNameFind(oldName);
                        NavHostFragment.findNavController(StudentLogin.this).navigate(R.id.action_studentLogin_to_studentUpdate);

                }
            }
        });
        binding.studentquit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(StudentLogin.this).navigate(R.id.action_studentLogin_to_studentAppOptions);
            }
        });{

        }
}
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
