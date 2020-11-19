import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TaskItem {
    private String title;
    private String description;
    private String dueDate;
    private boolean complete;

    public TaskItem(String title, String description, String dueDate) {
        this.complete = false;
        if(isTitleValid(title)) {
            this.title = title;
        }
        else {
            throw new IllegalArgumentException("Title isn't long enough");
        }
        this.description = description;
        if(isValidDate(dueDate)) {
            this.dueDate = dueDate;
        }
        else
        {
            throw new IllegalArgumentException("Invalid date");
        }
    }


    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    public String getDate() {
        return this.dueDate;
    }

    public String setTitle(String title) {
        if(!isTitleValid(title))
            throw new IllegalArgumentException("Title isn't long enough");
        else
            return this.title = title;
    }

    public String setDescription(String desc) {
        return this.description = desc;
    }


    public String setDate(String date) {
        if(!isValidDate(date))
            throw new IllegalArgumentException("Invalid date");
        else
            return this.dueDate = date;
    }

    private boolean isTitleValid(String title) {
        return title.length() > 0;
    }

    public boolean getComplete() {
        return this.complete;
    }

    private boolean isValidDate(String inDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(inDate.trim());
        }
        catch (ParseException pe) {
            return false;
        }
        return true;
    }

    public boolean setComplete(boolean i) {
        if(this.complete != i)
            return this.complete = i;
        else
            System.out.println("Already complete");
        return i;
    }
}
