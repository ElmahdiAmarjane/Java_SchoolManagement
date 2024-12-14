package email_marketing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import email_marketing.model.User;

public class Cookies {
	//"src/main/java/donnees.txt"
	private String filePath;
	
	
	public Cookies() {
		this.filePath = "src/main/java/donnees.txt";
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	public void sauvegarderDonnees(User u) throws IOException {
        try  {
        	BufferedWriter writer = new BufferedWriter(new FileWriter(this.filePath));
            writer.write(u.toString());
        
            writer.close();
        }catch (IOException e) {
			e.printStackTrace();
		}
    }
	
	public void supprimerFichier() throws IOException {
		try  {
        	BufferedWriter writer = new BufferedWriter(new FileWriter(this.filePath));
//            writer.write("");
            writer.close();
        }catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public User chargerDonnees() throws IOException {
        try  {
        	BufferedReader reader = new BufferedReader(new FileReader(this.filePath));
        	String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].equals("User")) {
                	String id = parts[1];
                    String username = parts[2];
                    String email = parts[3];
                    
                    reader.close();
                    return new User(id, username, email);
                }
            }
            reader.close();
            return null; 
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
	
	

}
