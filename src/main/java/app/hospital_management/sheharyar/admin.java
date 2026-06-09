package app.hospital_management.sheharyar;

import java.util.InputMismatchException;
import java.util.Scanner;



public class admin {

    //function for deleting a receptionist
    static void remove_receptionist(Scanner sc){
        int input=1;

        while(input !=0){
            try{
                sc.nextLine();
                System.out.println("\n========Remove Receptionist========");
                FileManager.printAll("Receptionists.txt");
                System.out.print("\nEnter '0' to Exit OR Enter ID of the Doctor To Delete: ");

                input = sc.nextInt();
                FileManager.find_and_delete(input, "Receptionists.txt");

            }catch (InputMismatchException inputmissMatch){
                System.out.println("Please Enter a Numerical Value.");
            }
        }
    }

    // Function for registering new Receptionist
    static void add_Receptionist(Scanner sc){

        Receptionist toAddReceptionist = new Receptionist();
        String temp;
        sc.nextLine();

        try {
            System.out.println("\n========Adding Receptionists========");
            System.out.println("Enter Receptionists Info\n");
            System.out.print("Name: ");
            sc.reset();
            temp = sc.nextLine();
            toAddReceptionist.set_name(temp);

            System.out.print("CNIC NO: ");
            toAddReceptionist.set_cnic(sc.nextLong());

            System.out.print("Phone Number: ");
            toAddReceptionist.set_phonenumber(sc.nextLong());

            System.out.print("Enter Receptionists Id (100-999): 36");
            int tempReceptionistID = sc.nextInt();
            
            //Verifying Given ID is Valid.
            if(tempReceptionistID<1000 && tempReceptionistID>99){
                toAddReceptionist.set_receptionistId(tempReceptionistID);
            }else{
                System.out.println("Inalid Doctor ID");
                System.out.print("Enter receptionist Id (100-999): 36");
                tempReceptionistID = sc.nextInt();
                if(tempReceptionistID<1000 && tempReceptionistID>99){
                    toAddReceptionist.set_receptionistId(tempReceptionistID);
                }else return;
                
            }
            
            System.out.print("Enter Password For given Receptionist: ");
            toAddReceptionist.set_password(sc.next());

            System.out.print("\nAre You sure given information is correct? (y/n) ");
            char input = sc.next().toUpperCase().charAt(0);
            
        
            if(input == 'Y'){
                System.out.println("Saving...");
                FileManager.saveReceptionistDetailsToFile(toAddReceptionist);
                return;
            }

            return;
        } catch (InputMismatchException mismtach) {
            System.out.println("Invalid input enter numerical Value");
        }
        
    }

    //Menu for receptionist Management
    public static void receptionist_management(Scanner sc){
        int adminChoice =0;

        while (adminChoice!=3) {
            //Flushing \n stuck
            sc.nextLine();
            System.out.println("\n========Receptionist Menu========");
            System.out.println("1. Add Receptionist \n2. Remove Receptionist \n0. Exit");

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
                    add_Receptionist(sc);
                    continue;
                case 2:
                    remove_receptionist(sc);
                    continue;
            
                default:
                    System.out.println("Invalid Choice");
                    continue;
            }

        }
    }

    //Function for Deleting a Doctor
    static void remove_doctors(Scanner sc){
        int input=1;

        while(input !=0){
            try{
                sc.nextLine();
                System.out.println("\n========Remove Doctor========");
                FileManager.printAll("Doctors.txt");
                System.out.print("\nEnter '0' to Exit OR Enter ID of the Doctor To Delete: ");

                input = sc.nextInt();
                FileManager.find_and_delete(input, "Doctors.txt");

            }catch (InputMismatchException inputmissMatch){
                System.out.println("Please Enter a Numerical Value.");
            }
        }
    }

    //Function for Registering a new Doctor
    static void add_doctor(Scanner sc){

        Doctor toAddDocter = new Doctor();
        String temp;
        sc.nextLine();

        try {
            System.out.println("\n========Adding Doctor========");
            System.out.println("Enter Doctors Info\n");
            System.out.print("Name: ");
            sc.reset();
            temp = sc.nextLine();
            toAddDocter.set_name(temp);

            System.out.print("CNIC NO: ");
            toAddDocter.set_cnic(sc.nextLong());

            System.out.print("Phone Number: ");
            toAddDocter.set_phonenumber(sc.nextLong());

            System.out.print("Enter doctor Id (100-999): 26");
            int tempdoctorID = sc.nextInt();
            if(tempdoctorID<1000 && tempdoctorID>99){
                toAddDocter.set_docterId(tempdoctorID);
            }else{
                System.out.println("Inalid Doctor ID");
                System.out.print("Enter doctor Id (100-999): 26");
                tempdoctorID = sc.nextInt();
                if(tempdoctorID<1000 && tempdoctorID>99){
                    toAddDocter.set_docterId(tempdoctorID);
                }else{ return;}
            }
            
            System.out.println("enter Password For given Doctor: ");
            toAddDocter.set_password(sc.next());

            System.out.print("\nAre You sure given information is correct? (y/n) ");
            char input = sc.next().toUpperCase().charAt(0);
            
        
            if(input == 'Y'){
                System.out.println("Saving...");
                FileManager.saveDoctorDetailsToFile(toAddDocter);
                return;
            }

            return;
        } catch (InputMismatchException mismtach) {
            System.out.println("Invalid input enter numerical Value");
        }
        
    }

    //Docter management interface for admin
    public static void doctor_management(Scanner sc){
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
                    add_doctor(sc);
                    continue;
                case 2:
                    remove_doctors(sc);
                    continue;
            
                default:
                    System.out.println("Invalid Choice");
                    continue;
            }

        }
    }
    
    //Main manu for admin
    public static void admin_main_manu(Scanner sc){
        int adminChoice =0;
        while (adminChoice!=4) {
            //Flushing \n stuck
            sc.nextLine();
            System.out.println("\n========Main Menu========");
            System.out.println("1. Manage Doctors \n2. Manage Receptionist \n3. Change Login Details \n0. Exit");

            try {
                adminChoice = sc.nextInt();
            } catch (InputMismatchException missmatch) {
                System.out.println("Please Enter numerical value eg: 1 | 2 | 3 ");
            }

            switch (adminChoice) {
                case 0:
                    return;
                case 1:
                    doctor_management(sc);
                    continue;
                case 2:
                    receptionist_management(sc);
                    continue;
                default:
                    System.out.println("Invalid Choice");
                    continue;
            }

        }

    }

    //Login Page for Admin
    public static void admin_login_interface(Scanner sc){
        String username ="";
        String password ="";
        boolean loged_in = false;
        int attempt=3;

        while (!loged_in && attempt>=0) {
            System.out.println("\n=======================");

            try {
                System.out.print("Enter Username: ");
                username = sc.next();

                System.out.print("Enter Password: ");
                password = sc.next();
                
                
            } catch (Exception e) {
                System.out.println("Invalid Input");
            }
            if(FileManager.check_login_details_admin(username,password)){
                admin_main_manu(sc);
                loged_in = true;
                return;
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
