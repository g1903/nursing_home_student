package model;

import java.util.ArrayList;
import java.util.List;

public class Nursing extends Person{
    private long nursingid;
    private String phonenumber;
    private List<Treatment> allTreatments = new ArrayList<Treatment>();

    public Nursing(String firstName, String surname, long nursingid, String phonenumber) {
        super(firstName, surname);
        this.nursingid = nursingid;
        this.phonenumber = phonenumber;
    }

    @Override
    public String getFirstName() {
        return super.getFirstName();
    }

    @Override
    public String getSurname() {
        return super.getSurname();
    }

    private long nursingid() {
        return nursingid;
    }

    private String phonenumber() {
        return phonenumber;
    }

    public boolean add(Treatment m) {
        if (!this.allTreatments.contains(m)) {
            this.allTreatments.add(m);
            return true;
        }
        return false;
    }

    public String toString() {
        return "Nursing" +
                "\nnursingiD: " + this.nursingid() +
                "\nFirstname: " + this.getFirstName() +
                "\nSurname: " + this.getSurname() +
                "\nPhonenumber: " + this.phonenumber()+
                "\n";
    }


}
