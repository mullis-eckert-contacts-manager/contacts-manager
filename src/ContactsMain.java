import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ContactsMain {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Path contactPath = Paths.get("src","contacts.txt");
        
        List<String> contactText = Arrays.asList(
                "Jack Blank | 1231231234",
                "Jane Doe | 2342342345",
                "Sam Space | 3453453456");

        Files.write(contactPath, contactText);
        
        int userChoice;
        boolean continueLoop = true;
    
        do {
            userChoice = userResponse();
            switch (userChoice) {
                case 1:
                    listContacts();
                    break;
                case 2:
                    addContact();
                    break;
                case 4:
                    deleteContact();
                    break;
                case 5:
                    continueLoop = false;
            }
        } while(continueLoop);
    }
    
    //TODO: not printing the options list for some reason - need to figure out why
    
    // grab user response for switch-case
    public static int userResponse() {
        Scanner sc = new Scanner(System.in);

        System.out.println("1. View contacts.\n" +
                "2. Add a new contact.\n" +
                "3. Search a contact by name.\n" +
                "4. Delete an existing contact.\n" +
                "5. Exit.\n" +
                "Enter an option (1, 2, 3, 4 or 5):");

        return sc.nextInt();
    }

    // list all contacts
    public static void listContacts() {
        Path contactPath = Paths.get("src","contacts.txt");
        try {
            System.out.println("Name | Phone number\n"
                               + "---------------");
            List<String> listAllContacts = Files.readAllLines(contactPath);
            for (String contact : listAllContacts) {
                System.out.println(contact);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // add a new contact
    public static void addContact(){
        Path contactPath = Paths.get("src","contacts.txt");
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the name:");
        String name = sc.nextLine();
        System.out.println("Please enter the number:");
        String number = sc.nextLine();
        
        String concatContact = name + " | " + number;
        
        try {
            Files.write(contactPath, Arrays.asList(concatContact), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // deletes a contact from a numbered list
    public static void deleteContact() {
        Path contactPath = Paths.get("src","contacts.txt");
    
        try {
            List<String> listAllContacts = Files.readAllLines(contactPath);
            for (int i = 0; i < listAllContacts.size(); i++) {
                System.out.println((i + 1) + " - " + listAllContacts.get(i));
            }
    
            Scanner sc = new Scanner(System.in);
            System.out.println("Which contact would you like to delete?");
            int contactToDelete = sc.nextInt();
            listAllContacts.remove(contactToDelete - 1);
    
            System.out.println("Contact removed.");
            
            Files.write(contactPath, listAllContacts);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    
    }
}
