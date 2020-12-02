import java.util.Scanner;

public class ContactApp extends SelectApp {
    private static Scanner in = new Scanner(System.in);
    private static ContactList contacts;

    public ContactApp() {
        contacts = new ContactList();
    }

    public void contactMainMenu() {
        System.out.println("\nMain Menu");
        System.out.println("---------");
        System.out.println("1) create a new list");
        System.out.println("2) load an existing list");
        System.out.println("3) quit");
        int input = in.nextInt();

        if(input == 1) {
            System.out.println("new contact list has been created");
            contactOperationMenu();
        }
        else if(input == 2) {
            System.out.println("Enter the filename to load: ");
            in.nextLine();
            String filename = in.nextLine();
            contacts.read(filename);
            contactOperationMenu();
        }
        else if(input == 3) {
            appSelect();
        }
        else {
            System.out.println("Invalid option. Please choose another option");
            contactMainMenu();
        }
    }

    private void contactOperationMenu() {
        System.out.println("\nList Operation Menu");
        System.out.println("---------");
        System.out.println("1) view the list");
        System.out.println("2) add an item");
        System.out.println("3) edit an item");
        System.out.println("4) remove an item");
        System.out.println("5) save the current list");
        System.out.println("6) quit to the main menu");
        System.out.println("\n");
        int input = in.nextInt();

        if(input == 1) {
            System.out.println("Current Contacts");
            System.out.println("---------\n");
            contacts.view();
            contactOperationMenu();
        }
        else if(input == 2) {
            process();
            contactOperationMenu();
        }
        else if(input == 3) {
            System.out.println("Which contact will you edit?");
            int index = in.nextInt();
            replaceDetails(index);
            contactOperationMenu();
        }
        else if(input == 4) {
            System.out.println("Which contact will you remove?");
            int index = in.nextInt();
            removeContactItem(index);
            contactOperationMenu();
        }
        else if(input == 5) {
            System.out.println("Enter the filename to save as: ");
            in.nextLine();
            String filename = in.nextLine();
            String filename2 = "\""+filename+"\"";
            writeData(filename2);
            for(int i = 0; i< contacts.size(); i++)
            {
                contacts.remove(i);
            }
            contactOperationMenu();
        }
        else if(input == 6) {
            contactMainMenu();
        }
        else {
            System.out.println("Error. Please try another option");
            contactOperationMenu();
        }
    }

    private void writeData(String filename) {
        contacts.write(""+filename+"");
        System.out.println("contact list has been saved");
    }

    private void process() {
        ContactItem data = getContactDetail();
        storeContactItem(data);
    }

    private void replaceDetails(int i) {
        ContactItem data = editContactItem(i);
        contacts.replace(i,data);
    }

    private void storeContactItem(ContactItem data) {
        contacts.add(data);
    }

    private void removeContactItem(int i) {
        try {
            contacts.remove(i);
        }
        catch(IndexOutOfBoundsException ex) {
            System.out.println("The index you chose was not valid");
        }
    }

    private ContactItem editContactItem(int i) {
        ContactItem newContact;
        while(true) {
            try {
                String firstName = getNewFirst(i);

                String lastName = getNewLast(i);

                String phone = getNewPhone(i);

                String email = getNewEmail(i);

                newContact = new ContactItem(firstName, lastName, phone, email);
                break;
            }
            catch(InvalidContactException ex) {
                System.out.println("Warning: contact cannot be empty");
            }
        }
        return newContact;
    }

    private ContactItem getContactDetail() {
        ContactItem details;
        while(true) {
            try {
                String firstName = getFirst();

                String lastName = getLast();

                String phone = getPhone();

                String email = getEmail();

                details = new ContactItem(firstName, lastName, phone, email);
                break;
            }
            catch(InvalidTitleException ex) {
                System.out.println("Warning: your title is invalid");
            }
            catch(InvalidDateException ex) {
                System.out.println("Warning: your date is invalid");
            }
        }
        return details;
    }

    private String getFirst() {
        System.out.println("First name: ");
        in.nextLine();
        return in.nextLine();
    }

    private String getLast() {
        System.out.println("Last name: ");
        return in.nextLine();
    }

    private String getPhone() {
        System.out.println("Phone number (xxx-xxx-xxxx): ");
        return in.nextLine();
    }

    private String getEmail() {
        System.out.println("Email address (x@y.z): ");
        return in.nextLine();
    }

    private String getNewFirst(int i) {
        System.out.println("Enter a new first name for contact "+i+": ");
        in.nextLine();
        return in.nextLine();
    }

    private String getNewLast(int i) {
        System.out.println("Enter a new last name for contact " +i+": ");
        return in.nextLine();
    }

    private String getNewPhone(int i)
    {
        System.out.println("Enter a new phone number (xxx-xxx-xxxx) for contact "+i+": ");
        return in.nextLine();
    }

    private String getNewEmail(int i)
    {
        System.out.println("Enter a new email address (x@y.z) for contact "+i+": ");
        return in.nextLine();
    }
}

class InvalidContactException extends IllegalArgumentException {
    public InvalidContactException(String msg) {
        super(msg);
    }
}
