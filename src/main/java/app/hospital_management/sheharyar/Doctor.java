package app.hospital_management.sheharyar;

public class Doctor extends Person{
    static int totalNumOfDoctors;
    private int doctorID = 26000;
    

    //getter and setter for doctor id
    public int get_doctorId(){
        return this.doctorID;
    }
    void set_docterId(int id){
        this.doctorID = 26000;
        this.doctorID += id;
    }

    
}
