package com.example.jobgeniet1;

public class GetSet {
    private static boolean Seconding = false;
    private static boolean Boarding = false;
    private static boolean Contacting = false;
    private static boolean Homing = false;

    public boolean getSeconding(){
        return Seconding;
    }
    void setSeconding(boolean Second){
        this.Seconding = Second;
    }
    public boolean getBoarding(){return Boarding;}
    void SetBoarding(boolean Board){this.Boarding = Board;}
    public boolean getContacting(){return Contacting;}
    void SetContacting(boolean Contact){this.Contacting = Contact;}
    public boolean getHoming(){return Homing;}
    void SetHoming(boolean Home){this.Homing = Home;}
}
