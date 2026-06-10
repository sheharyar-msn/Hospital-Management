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

    //Patients management interface for receptionist
    private static void patient_management(Scanner sc){
        int adminChoice =0;

        while (adminChoice!=3) {
            //Flushing \n stuck
            sc.nextLine();
            System.out.println("\n========Main Menu========");
            System.out.println("1. Add Doctor \n2. Remove Doctor \n0. Exit");

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

                    continue;
                case 2:
                    
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
            System.out.println("1. Manage Patients \n2. Doctors \n0. Exit");

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

                    continue;
                case 2:

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
                // doctor_main_manu(sc, Integer.parseInt(userID));
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
