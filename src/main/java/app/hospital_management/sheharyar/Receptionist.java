package app.hospital_management.sheharyar;

import java.util.InputMismatchException;
import java.util.Scanner;

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


    private static void delete_patient(Scanner sc){
        int userIn= 1;

        while(userIn != 0){

            System.out.println("\n======== Patient Manager ========");
            FileManager.printAllpatients();
            System.out.print("\nEnter '0' To Exit OR enter Patient ID to Delete: ");
            try {
                //Flashing \n from Scanner
                sc.nextLine();
                userIn = sc.nextInt();
            } catch(InputMismatchException a ){
                System.out.println("Please Enter Numerical Value");
            }
            catch (Exception e) {
                System.out.println("Error Occured.");
            }

            FileManager.find_and_delete(userIn, "Patients.txt");

        }
    }


    //Function for Registering a new Patient
    private static void add_patient(Scanner sc){

        Patient toAddPatient = new Patient();
        String temp;
        sc.nextLine();


        try {
            System.out.println("\n========Adding Patient========");
            System.out.println("Enter Patient Info\n");

            System.out.print("Name: ");
            sc.reset();
            temp = sc.nextLine();
            toAddPatient.set_name(temp);

            System.out.print("CNIC NO: ");
            toAddPatient.set_cnic(sc.nextLong());

            System.out.print("Phone Number: ");
            toAddPatient.set_phonenumber(sc.nextLong());

            System.out.print("Doctor ID: ");
            toAddPatient.doctorID = sc.nextInt();

            System.out.print("Bill: ");
            toAddPatient.bill = sc.nextInt();

            System.out.print("Enter Patient Id (100-999): 66");
            int tempPatientID = sc.nextInt();
            if(tempPatientID<1000 && tempPatientID>99){
                toAddPatient.patientID = tempPatientID;
            }else{
                System.out.println("Inalid Patient ID");
                System.out.print("Enter Patient Id (100-999): 66");
                tempPatientID = sc.nextInt();
                if(tempPatientID<1000 && tempPatientID>99){
                    toAddPatient.patientID = tempPatientID;
                }else{ return;}
            }

            System.out.print("\nAre You sure given information is correct? (y/n) ");
            char input = sc.next().toUpperCase().charAt(0);
            
            if(input == 'Y'){
                System.out.println("Saving...");
                FileManager.savePatientDetailsToFile(toAddPatient);
                return;
            }

            return;
        } catch (InputMismatchException mismtach) {
            System.out.println("Invalid input enter numerical Value");
        }
        
    }

    //Patients management interface for receptionist
    private static void patient_management(Scanner sc){
        int adminChoice =0;

        while (adminChoice!=3) {
            //Flushing \n stuck
            sc.nextLine();
            System.out.println("\n======== Patient Management ========");
            System.out.println("1. Display All Patients \n2. Add Patient \n3. Remove Patient \n0. Exit");

            try {
                adminChoice = sc.nextInt();
            } catch (InputMismatchException missmatch) {
                System.out.println("Please Enter numerical value eg: 0 | 1 | 2 ");
                continue;
            }

            
            switch (adminChoice) {
                case 0:
                    return;
                case 1:
                    FileManager.printAllpatients();
                    continue;
                case 2:
                    add_patient(sc);
                    continue;
                case 3:
                    delete_patient(sc);
                    continue;
            
                default:
                    System.out.println("Invalid Choice");
                    continue;
            }

        }
    }

    //main Manu for receptionist
    private static void receptionist_mainManu(Scanner sc){
        int adminChoice =0;

        while (adminChoice!=3) {
            //Flushing \n stuck
            sc.nextLine();
            System.out.println("\n========Main Menu========");
            System.out.println("1. Manage Patients \n2. Display all Doctors \n0. Exit");

            try {
                adminChoice = sc.nextInt();
            } catch (InputMismatchException missmatch) {
                System.out.println("Please Enter numerical value eg: 0 | 1 | 2 ");
                continue;
            }

            
            switch (adminChoice) {
                case 0:
                    return;
                case 1:
                    patient_management(sc);
                    continue;
                case 2:
                    FileManager.printAll("Doctors.txt");
                    continue;
            
                default:
                    System.out.println("Invalid Choice");
                    continue;
            }

        }
    }

    //Login Page for receptionist
    public static void receptionist_login_interface(Scanner sc){
        String userID ="";
        String password ="";
        boolean loged_in = false;
        int attempt=3;

        while (!loged_in && attempt>=0) {
            System.out.println("\n=========== Receptionist Login ============");

            try {
                sc.nextLine();
                System.out.print("Enter User ID: ");
                userID = sc.next();

                System.out.print("Enter Password: ");
                password = sc.next();
                
                
            } catch (Exception e) {
                System.out.println("Invalid Input");
            }
            if(FileManager.check_login_details(userID,password,"Receptionists.txt")){
                receptionist_mainManu(sc);
                loged_in = true;
            }else{
                System.out.println("\n"+attempt+" Attempts left");
            }
            attempt--;
        }
        if(!loged_in){
            System.out.println("Maximun tries reached");
            return;
        }
    }

}
