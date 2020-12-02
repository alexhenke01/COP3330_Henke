import java.util.ArrayList;
import java.util.List;
import java.util.Formatter;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;

public class ContactList {
    List<ContactItem> contacts;

    public ContactList() {
        contacts = new ArrayList<>();
    }

    public ContactItem get(int i) {
        if(i < 0) {
            throw new IllegalArgumentException("index must be positive (including 0)");
        }
        if(i > contacts.size()) {
            throw new IndexOutOfBoundsException("index exceeds the size of ContactList");
        }
        return contacts.get(i);
    }

    public void remove(int i)
    {
        contacts.remove(i);
    }

    public void replace(int i, ContactItem data)
    {
        try {
            contacts.set(i, data);
        }
        catch(ArrayIndexOutOfBoundsException ex) {
            System.out.println("Out of bounds index, unable to replace contact with new one");
        }
    }

    public void add(ContactItem data) {
        contacts.add(data);
    }

    public int size() {
        return contacts.size();
    }

    public void read(String filename) {
        try {
            File obj = new File("\""+filename+"\"");
            Scanner reader = new Scanner(obj);
            while(reader.hasNextLine()) {
                String firstName = reader.next();
                String lastName = reader.next();
                String phone = reader.next();
                String email = reader.next();
                ContactItem newContact = new ContactItem(firstName, lastName, phone, email);
                contacts.add(newContact);
            }
            System.out.println("contact list have been loaded");
            reader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println("File not found");
            ex.printStackTrace();
        }
    }

    public void write(String filename) {
        try(Formatter output = new Formatter(filename)) {
            for(int i = 0; i < contacts.size(); i++) {
                ContactItem data = contacts.get(i);
                output.format("%s %s %s %s", data.getFirst(), data.getLast(), data.getPhone(), data.getEmail());
            }
        }
        catch(FileNotFoundException ex) {
            System.out.println("Unable to find file...");
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public void view() {
        for(int i = 0; i < contacts.size(); i++) {
            ContactItem data = contacts.get(i);
            System.out.println(i+") Name: " + data.getFirst() + " " + data.getLast() + "\nPhone: " + data.getPhone() +
                    "\nEmail: " + data.getEmail());
        }
    }
}
