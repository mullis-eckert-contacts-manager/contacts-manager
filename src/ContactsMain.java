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
        Path contactPath = Paths.get("contacts.txt");

        List<Contact> contacts;
        List<String> contactText = Arrays.asList(
                "Jack Blank:1231231234",
                "Jane Doe:2342342345",
                "Sam Space:3453453456");

        Files.write(contactPath, contactText, StandardOpenOption.APPEND);

//        System.out.println(contactText);
        contacts = Contact.stringsToContacts(contactText);

        listContacts(contacts); //TODO:comment out when not used for testing

        System.out.println("1. View contacts.\n" +
                "2. Add a new contact.\n" +
                "3. Search a contact by name.\n" +
                "4. Delete an existing contact.\n" +
                "5. Exit.\n" +
                "Enter an option (1, 2, 3, 4 or 5):");

        //TODO: create some sort of switch case for the user options

//        String option = sc.nextLine();
//        switch(option) {
//            case 1: listContacts(contacts);
//            break;
//            case 2: addContact();
//            default: break;
//        }
    }

    public static void listContacts(List<Contact> contacts) {
        for (Contact contact : contacts) {
            System.out.println(contact.getName() + " | " + contact.getNumber());
        }
    }


    //TODO: properly write and test addContact method.

    public static void addContact(Path contactPath) throws IOException{
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the name:");
        String name = sc.nextLine();
        System.out.println("Please enter the number:");
        String number = sc.nextLine();
        Files.write(contactPath, Arrays.asList(name + ":" + number), StandardOpenOption.APPEND);
    }
}
