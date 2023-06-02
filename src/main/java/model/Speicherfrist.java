package model;

import java.util.ArrayList;
import java.util.List;

public class Speicherfrist {
    private Treatment treatment;
    private Patient patient;
    private Date ablauftermin;
    private String nursing;
    private String nursingid;

    public Speicherfrist(Treatment treatment, Patient patient, Date ablauftermin, String nursing, String nursingid){
        this.treatment= treatment;
        this.patient= patient;
        this.ablauftermin= ablauftermin;
        this.nursing = nursing;
        this.nursingid = nursingid;
    }

    public Treatment Treatment() {
        return treatment;
    }

    public Patient Patient() {
        return patient;
    }

    public Date ablauftermin() {
        return ablauftermin;
    }

    public String nursing() {
        return nursing;
    }

    public String nursingid(){
        return nursingid;
    }

    public String toString() {
        return "Speicherfrist" +
                "\nTreatment: " + this.Treatment() +
                "\nPatient: " + this.Patient() +
                "\nAblauftermin: " + this.ablauftermin() +
                "\nNursing: " + this.nursing() +
                "\nnursingid: " + this.nursingid()+
                "\n";
    }

    List<Treatment> Date = new ArrayList<>();
    List<Patient> Aufnahmedatum = new ArrayList<>();
    List<Date> ablaufdaten = new ArrayList<>();

    public void Löschen(Treatment treatment, Patient patient){

    }
}
