package com.example.jobgeniet1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StudentAdapt extends RecyclerView.Adapter<StudentAdapt.ViewHold>{ private Context context;
    private ArrayList name, skills, international, salary;

    public StudentAdapt(Context context, ArrayList name, ArrayList skills, ArrayList international, ArrayList salary)  {
        this.context = context;
        this.name = name;
        this.skills = skills;
        this.international = international;
        this.salary = salary;
    }

    @NonNull
    @Override
    public StudentAdapt.ViewHold onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.company_entry,parent,false);
        return new StudentAdapt.ViewHold(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHold holder, int position) {
        holder.name.setText(String.valueOf(name.get(position)));
        holder.skills.setText(String.valueOf(skills.get(position)));
        holder.international.setText(String.valueOf(international.get(position)));
        holder.salary.setText(String.valueOf(salary));
    }

    @Override
    public int getItemCount() {
        return name.size();
    }

    public class ViewHold extends RecyclerView.ViewHolder {
        TextView name,skills,international,salary;
        public ViewHold(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.studenttextname);
            skills = itemView.findViewById(R.id.studenttextSkills);
            international = itemView.findViewById(R.id.studenttextInternational);
            salary=itemView.findViewById(R.id.studenttextSalary);
        }
    }
}

