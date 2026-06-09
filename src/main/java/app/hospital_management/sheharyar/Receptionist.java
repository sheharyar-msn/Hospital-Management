package app.hospital_management.sheharyar;

public class Receptionist extends Person {
    private int receptionistID = 36000;
    

    //getter and setter for doctor id
    public int get_receptionistId(){
        return this.receptionistID;
    }
    void set_receptionistId(int id){
        receptionistID = 36000;
        this.receptionistID += id;
    }
}
