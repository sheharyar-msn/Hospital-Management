package app.hospital_management.sheharyar;

public class Patient extends Person{
    int patientID;
    int doctorID;
    int bill;
    String history;

    //getter and setter for doctor id
    public int get_patientId(){
        return this.patientID;
    }
    void set_patientId(int id){
        this.patientID = 66000;
        this.patientID += id;
    }
}
