package com.example.jobgeniet1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.jobgeniet1.databinding.StudentadBinding;

public class StudentAD extends Fragment {
    private StudentadBinding binding;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = StudentadBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        DBhelper Dat = new DBhelper(getContext());
        TextView e1,e2;
        e1=(EditText) view.findViewById(R.id.editTextStudentDeleteCustomer);
        e2=(EditText) view.findViewById(R.id.editTextStudentDeleteSecurity);
        binding.StudentDeleteFull.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dat.deleteTableF("customers");
                Dat.deleteTableF("customers");
            }
        });
        binding.StudentDeleteSingle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                boolean CheckName = Dat.checkName(s1);
                boolean CheckUser = Dat.checkUser(s2);
                if(s1.equals("")||s2.equals("")){
                    Toast.makeText(getContext(),"A field is empty",Toast.LENGTH_LONG);
                }
                else if(CheckUser == true){
                    Toast.makeText(getContext(),"Username does not exist",Toast.LENGTH_LONG);
                }
                else if(CheckName == false){
                    Toast.makeText(getContext(),"Name does not exist",Toast.LENGTH_LONG);
                }
                else{
                    Dat.deleteTableS("customers",s1);
                    Dat.deleteTableS("security",s2);
                }

            }
        });
        binding.StudentADBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(StudentAD.this).navigate(R.id.action_studentAD_to_studentAppBoard);
            }
        });
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();

        binding = null;
    }
    }
