package app.hospital_management.sheharyar;

import java.util.Scanner;


public class Main {
    

    public static void main(String[] args) {

        //Scanner for inputs
        Scanner sc = new Scanner(System.in);

        //Asking user if its a receptionist or Doctor or a Admin
        int user_in = 0;
        while (user_in != 1 && user_in != 2 && user_in != 3 ) 
        {
            System.out.println("Are you a? (Chose Using number)");
            System.out.println("1. Docter \n2. Receptionist \n3. Admin");

            //Getiing Input from user with exception handling
            try {
                user_in = sc.nextInt();
            } catch (Exception InputMismatchException) {
                System.out.println("Please enter numerical value");
            }
        }

        switch (user_in) {
            case 1:
                Doctor.doctor_login_interface(sc);
                break;
            
            case 2:
                Receptionist.receptionist_login_interface(sc);
                break;
            case 3:
                admin.admin_login_interface(sc);

                break;
        }

        System.out.println("\nExiting Program..\n");
        return;


    }
}