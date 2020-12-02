import java.util.ArrayList;
import java.util.List;
import java.util.Formatter;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;

public class TaskList {
    List<TaskItem> tasks;

    public TaskList() {
        tasks = new ArrayList<>();
    }

    public TaskItem get(int i) {
        if(i < 0) {
            throw new IllegalArgumentException("Index must be positive (or 0)");
        }
        if(i > tasks.size()) {
            throw new IndexOutOfBoundsException("Index exceeds the size of TaskList");
        }
        return tasks.get(i);
    }

    public void remove(int i) {
        tasks.remove(i);
    }

    public void replace(int i, TaskItem data) {
        try {
            tasks.set(i, data);
        }
        catch(ArrayIndexOutOfBoundsException ex) {
            System.out.println("Out of index, Unable to replace task with new one");
        }
    }

    public void add(TaskItem data) {
        tasks.add(data);
    }

    public boolean completed(TaskItem data) {
        return data.getComplete();
    }

    public int size() {
        return tasks.size();
    }

    public void read(String filename) {
        try {
            File obj = new File("\""+filename+"\"");
            Scanner reader = new Scanner(obj);
            while(reader.hasNextLine()) {
                String dueDate = reader.next();
                String title = reader.next();
                String desc = reader.next();
                TaskItem newtask = new TaskItem(title, desc, dueDate);
                tasks.add(newtask);
            }
            System.out.println("task list have been loaded");
            reader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println("File not found");
            ex.printStackTrace();
        }
    }


    public void write(String filename) {
        try(Formatter output = new Formatter(filename)) {
            for(int i = 0; i < tasks.size(); i++) {
                TaskItem data = tasks.get(i);
                output.format("%s %s %s", data.getDate(), data.getTitle(), data.getDescription());
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
        for(int i = 0; i < tasks.size(); i++) {
            TaskItem data = tasks.get(i);
            if(data.getComplete())
                System.out.println(i+") *** ["+data.getDate()+"] " + data.getTitle()+ ": "+data.getDescription());
            else
                System.out.println(i+") ["+data.getDate()+"] " + data.getTitle()+ ": "+data.getDescription());
        }
    }
}
