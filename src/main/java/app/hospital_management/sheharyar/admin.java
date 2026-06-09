package app.hospital_management.sheharyar;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.InputMismatchException;
import java.util.Scanner;



public class admin {

    private void find_and_delete(int doctorToDelete){
        try {
            BufferedReader read_doctors = new BufferedReader(new FileReader("Doctors.txt"));
            String line;
            while ((line = read_doctors.readLine()) != null) {
                if (line.isEmpty()) {
                    continue;
                }

                //Format of each doctor in file "ID,Passowrd,Name,CNIC,Phone Number"
                

                
            }

            read_doctors.close();

        } catch (FileNotFoundException FileNotFoundException) {
                System.out.println("Doctors Not available");                
        }catch (Exception e){
            System.out.println("Error: "+e);
        }
    }


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

    public static void add_doctor(Scanner sc){

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
                System.out.println("Please Enter numerical value eg: 1 | 2 | 3 ");
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
