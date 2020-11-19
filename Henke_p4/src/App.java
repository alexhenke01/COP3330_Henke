import java.util.Scanner;


public class App {

    private static Scanner in = new Scanner(System.in);

    private static TaskList tasks;

    public App() {
        tasks = new TaskList();
    }

    public static void main(String[] args) {
        App a = new App();
        a.mainMenu();
    }

    private void mainMenu() {
        System.out.println("\nMain Menu");
        System.out.println("---------");
        System.out.println("1) create a new list");
        System.out.println("2) load an existing list");
        System.out.println("3) quit");
        int input = in.nextInt();

        if(input == 1) {
            System.out.println("new task list has been created");
            listOperationMenu();
        }
        else if(input == 2) {
            System.out.println("Enter the filename to load: ");
            in.nextLine();
            String filename = in.nextLine();
            tasks.read(filename);
            listOperationMenu();
        }
        else if(input == 3) {
            System.exit(0);
        }
        else {
            System.out.println("Invalid option. Please choose another option");
            mainMenu();
        }

    }

    private void listOperationMenu() {
        System.out.println("\nList Operation Menu");
        System.out.println("---------");
        System.out.println("1) view the list");
        System.out.println("2) add an item");
        System.out.println("3) edit an item");
        System.out.println("4) remove an item");
        System.out.println("5) mark an item as completed");
        System.out.println("6) unmark an item as completed");
        System.out.println("7) save the current list");
        System.out.println("8) quit to the main menu");
        System.out.println("\n");
        int input = in.nextInt();

        if(input == 1) {
            System.out.println("Current Tasks");
            System.out.println("---------\n");
            tasks.view();
            listOperationMenu();
        }
        else if(input == 2) {
            process();
            listOperationMenu();
        }
        else if(input == 3) {
            System.out.println("Which task will you edit?");
            int index = in.nextInt();
            replaceDetails(index);
            listOperationMenu();
        }
        else if(input == 4) {
            System.out.println("Which task will you remove?");
            int index = in.nextInt();
            removeTaskItem(index);
            listOperationMenu();
        }
        else if(input == 5) {
            System.out.println("Which task will you mark as completed?");
            int index = in.nextInt();
            mark(index);
            listOperationMenu();
        }
        else if(input == 6) {
            System.out.println("Which task will you unmark as completed?");
            int index = in.nextInt();
            unmark(index);
            listOperationMenu();
        }
        else if(input == 7) {
            System.out.println("Enter the filename to save as: ");
            in.nextLine();
            String filename = in.nextLine();
            String filename2 = "\""+filename+"\"";
            writeData(filename2);
            for(int i=0; i<tasks.size(); i++)
            {
                tasks.remove(i);
            }
            listOperationMenu();
        }
        else if(input == 8) {
            mainMenu();
        }
        else {
            System.out.println("Error. Please try another option");
            listOperationMenu();
        }
    }

    private void writeData(String filename) {
        tasks.write(""+filename+"");
        System.out.println("task list has been saved");
    }

    private TaskItem process() {
        TaskItem data = getTaskDetail();
        storeTaskItem(data);
        return data;
    }

    private TaskItem replaceDetails(int i) {
        TaskItem data = editTaskItem(i);

        tasks.replace(i,data);
        return data;
    }

    private void mark(int i) {
        try {
            tasks.get(i).setComplete(true);
        }
        catch(IndexOutOfBoundsException ex) {
            System.out.println("The index you chose was not valid");
        }
    }

    private void unmark(int i) {
        try {
            tasks.get(i).setComplete(false);
        }
        catch(IndexOutOfBoundsException ex) {
            System.out.println("The index you chose was not valid");
        }
    }

    private void storeTaskItem(TaskItem data) {
        tasks.add(data);
    }

    private void removeTaskItem(int i) {
        try {
            tasks.remove(i);
        }
        catch(IndexOutOfBoundsException ex) {
            System.out.println("The index you chose was not valid");
        }
    }

    private TaskItem editTaskItem(int i) {
        TaskItem newTask;
        while(true) {
            try {
                String title = getNewTitle(i);

                String description = getNewDescription(i);

                String date = getNewDueDate(i);

                newTask = new TaskItem(title, description, date);
                break;
            }
            catch(InvalidTitleException ex) {
                System.out.println("Warning: your title is invalid");
            }
            catch(InvalidDateException ex) {
                System.out.println("Warning: your date is invalid");
            }
        }
        return newTask;
    }

    private TaskItem getTaskDetail() {
        TaskItem details;
        while(true) {
            try {
                String title = getTitle();

                String description = getDescription();

                String date = getDueDate();

                details = new TaskItem(title, description, date);
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

    private String getTitle() {
        System.out.println("Task title: ");
        in.nextLine();
        return in.nextLine();
    }

    private String getDescription() {
        System.out.println("Task description: ");
        return in.nextLine();
    }

    private String getDueDate() {
        System.out.println("Task due date (YYYY-MM-DD): ");
        return in.nextLine();
    }

    private String getNewTitle(int i) {
        System.out.println("Enter a new title for task "+i+": ");
        in.nextLine();
        return in.nextLine();
    }

    private String getNewDescription(int i) {
        System.out.println("Enter a new description for task" +i+": ");
        return in.nextLine();
    }

    private String getNewDueDate(int i)
    {
        System.out.println("Enter a new task due date (YYYY-MM-DD) for task"+i+": ");
        return in.nextLine();
    }
}

class InvalidTitleException extends IllegalArgumentException {
    public InvalidTitleException(String msg) {
        super(msg);
    }
}

class InvalidDateException extends IllegalArgumentException {
    public InvalidDateException(String msg) {
        super(msg);
    }

}

