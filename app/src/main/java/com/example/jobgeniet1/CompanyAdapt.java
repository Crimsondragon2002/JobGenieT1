package com.example.jobgeniet1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CompanyAdapt extends RecyclerView.Adapter<CompanyAdapt.ViewHold> {
    private Context context;
    private ArrayList name, skills, international, salary;

    public CompanyAdapt(Context context, ArrayList name, ArrayList skills, ArrayList international, ArrayList salary)  {
        this.context = context;
        this.name = name;
        this.skills = skills;
        this.international = international;
        this.salary = salary;
    }

    @NonNull
    @Override
    public ViewHold onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.company_entry,parent,false);
        return new ViewHold(v);
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
            name = itemView.findViewById(R.id.textname);
            skills = itemView.findViewById(R.id.textSkills);
            international = itemView.findViewById(R.id.textInternational);
            salary=itemView.findViewById(R.id.textSalary);
        }
    }
}

