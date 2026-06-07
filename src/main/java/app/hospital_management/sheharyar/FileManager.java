package app.hospital_management.sheharyar;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileManager {

    public static boolean check_login_details(String username, String password){

        try {
            BufferedReader read_admin = new BufferedReader(new FileReader("admin_details"));
            String line;
            while ((line = read_admin.readLine()) != null) {
                if (line.isEmpty()) {
                    continue;
                }

                String lines[] = line.split(":", 2);
                String usernameInFile = lines[0];
                String passwordInFile = lines[1];

                if(usernameInFile.equals(username) && passwordInFile.equals(password)){
                    return true;

                }else{
                    return false;
                }
            }

        } catch (FileNotFoundException FileNotFoundException) {
                System.out.println("Admin file does not exist.");
        }catch (Exception e){
            System.out.println("Error: "+e);
        }
        return false;
    }
    
}
