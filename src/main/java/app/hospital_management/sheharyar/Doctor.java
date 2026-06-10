package app.hospital_management.sheharyar;

import java.util.InputMismatchException;
import java.util.Scanner;

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

    //His patients
    private static void doctor_main_manu(Scanner sc, int currDoctorId){
        int userInput =1;
        while (userInput!=0) {
            //Flushing \n stuck
            sc.nextLine();
            System.out.println("\n========Current Patients========");
            FileManager.printAllpatients(currDoctorId);

            System.out.println("\nEnter '0' to Exit");
            System.out.print("Enter Patient ID To Update the History: ");

            try {
                userInput = sc.nextInt();
                if(userInput == 0){
                    return;
                }else{
                    sc.nextLine();
                    System.out.print("Enter New Hisoty: ");
                    String newHistory = sc.nextLine();
                    FileManager.updateHistory(userInput, newHistory);
                }
            } catch (InputMismatchException missmatch) {
                System.out.println("Please Enter numerical value.");
            }catch (Exception e){
                System.out.println("An Error occured");
            }
        }
    }
    
    public static void doctor_login_interface(Scanner sc){
        String userID ="";
        String password ="";
        boolean loged_in = false;
        int attempt=3;

        while (!loged_in && attempt>=0) {
            System.out.println("\n=========== Doctor Login ============");

            try {
                sc.nextLine();
                System.out.print("Enter User ID: ");
                userID = sc.next();

                System.out.print("Enter Password: ");
                password = sc.next();
                
                
            } catch (Exception e) {
                System.out.println("Invalid Input");
            }
            if(FileManager.check_login_details(userID,password,"Doctors.txt")){
                doctor_main_manu(sc, Integer.parseInt(userID));
                System.out.println("called main manu function");
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
