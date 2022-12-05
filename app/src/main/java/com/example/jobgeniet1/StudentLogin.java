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
        e1 =(EditText) view.findViewById(R.id.studentusername);
        e2 =(EditText) view.findViewById(R.id.studentpassword);
        e3 = (EditText) view.findViewById(R.id.oldName);
        final int[] j = new int[1];
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
                    Toast.makeText(getActivity().getApplicationContext(),"A field is empty",Toast.LENGTH_LONG);
                    Log.i("warning","field empty");
                }
                else if(checkUser == false){
                    Toast.makeText(getActivity().getApplicationContext(),"Username or password is incorrect",Toast.LENGTH_LONG);
                    Log.i("warning","user false");
                }
                else if(checkName == true){
                    Toast.makeText(getContext(),"Name is incorrect",Toast.LENGTH_LONG);
                    Log.i("warning","name false");
                    String[] rows = Dat.getsecureRows(1);
                    String[] nameRows = Dat.getRows(1);
                    for(int i=0;i<500;i++){
                        if(user.equals(rows[i])){
                            j[0] = i;
                        }
                    }
                    Log.i("sighting","wants "+nameRows[j[0]]+" sees " +oldName);
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
