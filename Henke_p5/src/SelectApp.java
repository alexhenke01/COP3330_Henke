import java.util.Scanner;

public class SelectApp {
    private static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        SelectApp a = new SelectApp();
        a.appSelect();
    }
    
    public void appSelect(){
        TaskApp t = new TaskApp();
        ContactApp c = new ContactApp();
        System.out.println("\nSelect Your Application");
        System.out.println("-----------------------");
        System.out.println("1) task list");
        System.out.println("2) contact list");
        System.out.println("3) quit");
        int input = in.nextInt();

        if(input == 1) {
            t.taskMainMenu();
        }
        else if(input == 2) {
            c.contactMainMenu();
        }
        else if(input == 3) {
            System.exit(0);
        }
        else {
            System.out.println("Invalid option. Please choose another option");
            appSelect();
        }
    }
}
