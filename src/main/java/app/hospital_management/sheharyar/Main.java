package app.hospital_management.sheharyar;

import java.util.Scanner;

public class Main {

    public static void docter(Scanner sc){

        String username;
        String password;
        boolean loged_in = false;

        while (!loged_in) {
            System.out.println("\n=======================");

            try {
                System.out.print("Enter User Name: ");
                username = sc.next();

                System.out.print("Enter Password: ");
                password = sc.next();
                
                
            } catch (Exception e) {
                System.out.println("Invalid Input");
            }

            //To:Do add condition to check password then precead..
        }
        

    }

    public static void receptionist(Scanner sc){

    }

    public static void admin(Scanner sc){

    }


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
                docter(sc);
                break;
            
            case 2:
                receptionist(sc);
                break;
            case 3:
                admin(sc);
                break;
        }


    }
}