package com.example.jobgeniet1;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.jobgeniet1.databinding.CompanyAppContactBinding;

public class CompanyAppContact extends Fragment {
    CompanyAppContactBinding binding;
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = CompanyAppContactBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        GetSet contacter = new GetSet();
        contacter.SetContacting(false);
        binding.CompanyBoard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(CompanyAppContact.this).navigate(R.id.action_companyAppContact_to_companyAppBoard);
            }
        });
        binding.CompanyHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(CompanyAppContact.this).navigate(R.id.action_companyAppContact_to_companyAppHome);
            }
        });
        binding.CompanyOptions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(CompanyAppContact.this).navigate(R.id.action_companyAppContact_to_companyAppOptions);
            }
        });
        binding.help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contacter.SetContacting(true);
                NavHostFragment.findNavController(CompanyAppContact.this).navigate(R.id.action_companyAppContact_to_companyFirstHelp);
            }
        });
        DBhelper Dat = new DBhelper(getContext());
        EditText ed1,ed2,ed3, ed4;
        ed1 = (EditText) view.findViewById(R.id.StudenteditTextSkills);
        ed2 = (EditText) view.findViewById(R.id.editTextInternational);
        ed3 = (EditText) view.findViewById(R.id.editTextMatchCount);
        ed4 = (EditText) view.findViewById(R.id.editTextSalary);
        binding.ViewData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String skills = ed1.getText().toString();
                String international = ed2.getText().toString();
                String matchCount = ed3.getText().toString();
                int matchCounting = Integer.parseInt(matchCount);
                String salary = ed4.getText().toString();
                int salar = Integer.parseInt(salary);
                String lowercaseSkills = skills.toLowerCase();
                String spacelessSkills = lowercaseSkills.replaceAll("\\s","");
                String[] newSkills = spacelessSkills.split("[,]",0);
                String[] row = Dat.getRows(0);
                String[] skillRow = Dat.getRows(1);
                String[] salaryRow = Dat.getRows(3);
                String skiller = "";
                int coreCount = 0;
                Log.i("sighting","first skill is " + skills);
                Log.i("sighting","lowercase skill is " + lowercaseSkills);
                Log.i("sighting","Spaceless skill is " + spacelessSkills);
                Log.i("sighting","new skill " + 0 +" is " + newSkills[0]);
                for(int i = 0; i < newSkills.length;i++) {
                    Log.i("sighting","skill " + i +" is " + newSkills[i]);
                }
                int matcher = 0;
                for(int i = 0; i<row.length;i++) {
                    matcher = 0;
                    for(int j = 0; j< newSkills.length;j++){
                        Boolean checkList = setEquals(row[i],newSkills[j],international,i, salar,0 );
                        if(checkList == true){
                            skiller+=newSkills[j]+",";
                            matcher++;
                            Log.i("sighting", "stored skiller is "+skiller);
                        }
                        Log.i("sighting","matchCounting is " + matchCounting +"while matcher is "+ matcher);
                        if(matchCounting<matcher){
                            Log.i("sighting","it goes in!");
                            boolean testing =Dat.insertList(row[i],skillRow[i],international,Integer.parseInt(salaryRow[i]));
                            if(testing == true){
                                Log.i("sighting","it works!");
                                String[] newRows = Dat.getListRows(0);
                                for(int k = 0;k< newRows.length;k++){
                                    Log.i("sighting","Name " + k + " is "+ newRows[k]);
                                    if(newRows[k+1]== null){
                                        break;
                                    }
                                }
                            }
                            break;
                        }
                        Log.i("sighting", "skiller is"+skiller);
                    }
                    skiller="";

                    if(row[i+1]==null){
                        break;
                    }
                }

                NavHostFragment.findNavController(CompanyAppContact.this).navigate(R.id.action_companyAppContact_to_companyView);

            }

        });
        binding.AddData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Dat.insertData("Charlie","fishing,climbing",20,"y",0);
                Dat.insertData("Steve","mining,crafting",15, "n",0);
                Dat.insertData("William","coding,testing,stuff",5,"n",0);
                Dat.insertData("Ellie","fishing,climbing,crafting",19,"y",0);
            }
        });
        binding.ClearData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dat.deleteTableF("list");
            }
        });
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
    public boolean setEquals(String name, String skills, String international, int i, int salary, int userType){
        DBhelper Dat =  new DBhelper(getContext());
        String skiller[] = Dat.getRows(1);
        String skilling = skiller[i];
        String lowercaseSkills = skilling.toLowerCase();
        String spacelessSkills = lowercaseSkills.replaceAll("\\s","");
        String[] newSkills = spacelessSkills.split("[,]",0);
        String internal[] = Dat.getRows(2);
        String[] sal = Dat.getRows(3);
        boolean skillEquals = false, internalEquals = false, salaryEquals= false, setEquals = false;
        if(international.equals("n")){
            if (internal[i].equals("n")){
                internalEquals = true;
            }
            else {
                internalEquals = false;
            }

        }
        else if(international.equals("y")){
            if (internal[i].equals("n")){
                internalEquals = true;
            }
            else {
                internalEquals = true;
            }
        }
        for(int k = 0; k< newSkills.length; k++){

            if(newSkills[k].equals(skills)){
                skillEquals = true;

                break;
            }

        }
        if(salary <= Integer.parseInt(sal[i])){
            salaryEquals = true;
        }
        boolean testEqual = false;
        if(skillEquals == true && internalEquals == true && salaryEquals == true){
            testEqual = true;
        }
        if(testEqual == true && userType == 0){
            setEquals = true;
        }
        return setEquals;
    }
}
