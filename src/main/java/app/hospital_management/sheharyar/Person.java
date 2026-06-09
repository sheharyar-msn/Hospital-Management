package app.hospital_management.sheharyar;

abstract class Person {
    private String name;
    private long cnic;
    private Long phone_number;
    private String tempPassword;

    //Setter and getter for name
    public void set_name(String name){
        this.name = name;
    }
    public String get_name(){
        return this.name;
    }

    //setter and getter for cnic
    public void set_cnic(long cnic){
        this.cnic = cnic;
    }
    public long get_cnic(){
        return this.cnic;
    }

    //Setter and Getter for Phone number
    public void set_phonenumber(long phoneNumber){
        this.phone_number = phoneNumber;
    }
    public long get_phonenumber(){
        return this.phone_number;
    }

    //Setter and getter for password
    public void set_password(String password){
        this.tempPassword = password;
    }
    public String get_password(){
        return this.tempPassword;
    }
}
