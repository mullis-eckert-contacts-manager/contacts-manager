import java.util.ArrayList;
import java.util.List;

public class Contact {
    private String name;
    private String number;

    public Contact(String name, String number) {
        this.name = name;
        this.number = number;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }

    public static List<Contact> stringsToContacts(List<String> contactText) {
        String[] nameAndNumber;
        List<Contact> contacts = new ArrayList<>();
        for (String contact : contactText) {
            nameAndNumber = contact.split(":");
            contacts.add(new Contact(nameAndNumber[0], nameAndNumber[1]));
        }
        return contacts;
    }
}
