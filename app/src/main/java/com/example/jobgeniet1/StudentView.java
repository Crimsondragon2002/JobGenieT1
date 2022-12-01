package com.example.jobgeniet1;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jobgeniet1.databinding.StudentViewBinding;

import java.util.ArrayList;

public class StudentView extends Fragment {
    private StudentViewBinding binding;
    RecyclerView recyclerView;
    ArrayList<String> name, skills, international, salary;
    DBhelper Dat;
    CompanyAdapt adapt;

    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState

    ) {

        binding = StudentViewBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view = getView();
        Dat = new DBhelper(getContext());
        name = new ArrayList<>();
        skills = new ArrayList<>();
        international = new ArrayList<>();
        salary = new ArrayList<>();
        recyclerView = view.findViewById(R.id.recyclerview);
        adapt = new CompanyAdapt(getContext(),name,skills,international, salary);
        recyclerView.setAdapter(adapt);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        displaydata();
        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(StudentView.this)
                        .navigate(R.id.action_studentView_to_studentAppContact);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
    private void  displaydata(){
        Cursor cursor = Dat.getList();
        if(cursor.getCount()==0)
        {
            Toast.makeText(getContext(), "No Entry Exists", Toast.LENGTH_SHORT).show();
            return;
        }
        else
        {
            while(cursor.moveToNext())
            {
                name.add(cursor.getString(0));
                skills.add(cursor.getString(1));
                international.add(cursor.getString(2));
                salary.add(cursor.getString(3));
            }
        }
    }

}

