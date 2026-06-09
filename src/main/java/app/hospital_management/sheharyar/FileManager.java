package app.hospital_management.sheharyar;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

public class FileManager {

    //universal Login details verifier
    public static Boolean check_login_details(String userID, String password, String fileName){
        try {
            BufferedReader readFile = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = readFile.readLine()) != null) {
                if (line.isEmpty()) {
                    continue;
                }

                String lines[] = line.split(",", 5);
                String usernameInFile = lines[0];
                String passwordInFile = lines[1];

                if(usernameInFile.equals(userID) && passwordInFile.equals(password)){
                    readFile.close();
                    return true;
                }
            }
            readFile.close();

        } catch (FileNotFoundException FileNotFoundException) {
                System.out.println("No User Found");
        }catch (Exception e){
            System.out.println("Error: "+e);
        }
        return false;
    }


    //Find and Delete from txt
    static void find_and_delete(int IDtoRemove,String fileName){

        try {
            File inputFile = new File(fileName);
            File tempFile = new File("myTempFile.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile,true));

            
            String line;

            while((line = reader.readLine()) != null) {
                // trim newline when comparing with lineToRemove

                String lines[] = line.split(",", 5);
                if(IDtoRemove == Integer.parseInt(lines[0])){
                    System.out.println("Found User");
                    continue;
                }else{
                    writer.write(line);
                    writer.newLine();
                }
                
            }
            
            writer.close(); 
            reader.close(); 
            // inputFile.renameTo(new File("Oldfile.txt"));
            inputFile.delete();
            
            if(! tempFile.renameTo(new File(fileName))){
                System.out.println("File rename error occured.");
            }
            tempFile.delete();

        } catch (Exception e) {
            System.out.println("Error Occured while Deleting User.");
        }
        

    }

    //View list of Members
    public static void printAll(String fileName){
        System.out.println("\nID\tName\tCNIC\tContect");
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
            String line;

            while ((line = fileReader.readLine()) != null) {

                //Format of each doctor in file "ID,Passowrd,Name,CNIC,Phone Number"
                String lines[] = line.split(",", 5);

                System.out.println(lines[0]+"\t"+lines[2]+"\t"+lines[3]+"\t"+lines[4]+"\t");
            }

            fileReader.close();

        } catch (FileNotFoundException FileNotFoundException) {
                System.out.println("Users Not available");                
        }catch (Exception e){
            System.out.println("Error: "+e);
        }

    }

    //Save Receptionist Details to File
    static void saveReceptionistDetailsToFile(Receptionist newReceptionist){
        File receptionists = new File("Receptionists.txt");
        
        if (!receptionists.exists()){
            try{
                receptionists.createNewFile();
            }catch(Exception e){
                System.out.println("Unable to create .txt file for Receptionists");
                return;
            }
        }

        //Writing New Doctor details txt file In "ID,Passowrd,Name,CNIC,Phone Number"
        try {
            BufferedWriter writter = new BufferedWriter(new FileWriter("Receptionists.txt",true));
            writter.write(newReceptionist.get_receptionistId()+","+newReceptionist.get_password()+","+newReceptionist.get_name()+","+newReceptionist.get_cnic()+","+newReceptionist.get_phonenumber());
            writter.newLine();
            writter.close();

        } catch (Exception e) {
            System.out.println("Error occured while saving Rceptionist details.");
        }
        System.out.println("Successfully Saved. ");
    }

    //Save Doctor Details to File
    static void saveDoctorDetailsToFile(Doctor newDoctor){
        File doctors = new File("Doctors.txt");
        
        if (!doctors.exists()){
            try{
                doctors.createNewFile();
            }catch(Exception e){
                System.out.println("Unable to create .txt file for Doctors");
                return;
            }
        }

        //Writing New Doctor details txt file In "ID,Passowrd,Name,CNIC,Phone Number"
        try {
            BufferedWriter writter = new BufferedWriter(new FileWriter("Doctors.txt",true));
            writter.write(newDoctor.get_doctorId()+","+newDoctor.get_password()+","+newDoctor.get_name()+","+newDoctor.get_cnic()+","+newDoctor.get_phonenumber());
            writter.newLine();
            writter.close();

        } catch (Exception e) {
            System.out.println("Error occured while saving doctor details.");
        }
        System.out.println("Successfully Saved. ");
    }

    //Function to check login credentional entered by admin are same as in saved files.
    public static boolean check_login_details_admin(String username, String password){

        try {
            BufferedReader read_admin = new BufferedReader(new FileReader("admin_details.txt"));
            String line;
            while ((line = read_admin.readLine()) != null) {
                if (line.isEmpty()) {
                    continue;
                }

                String lines[] = line.split(",", 2);
                String usernameInFile = lines[0];
                String passwordInFile = lines[1];

                if(usernameInFile.equals(username) && passwordInFile.equals(password)){
                    read_admin.close();
                    return true;
                }
            }
            read_admin.close();

        } catch (FileNotFoundException FileNotFoundException) {
                System.out.println("Admin file does not exist.");
                CreateDefaultAdmin();
                System.out.println("File Created");
                
        }catch (Exception e){
            System.out.println("Error: "+e);
        }
        return false;
    }

    //creating default admin login details when program is ran for first time
    private static void CreateDefaultAdmin(){
        try {
            File adminFile = new File("admin_details.txt");
            adminFile.createNewFile();
            FileWriter writter = new FileWriter("admin_details.txt");

            writter.write("sheharyar,admin");

            writter.close();

        } catch (Exception e) {
            System.out.println("Error occured when creating defult Admin.");
        }
        
    }
    
}
