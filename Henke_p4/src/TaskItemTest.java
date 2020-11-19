import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskItemTest {
    @Test
    public void creatingTaskItemFailsWithInvalidDueDate() {
        assertThrows(IllegalArgumentException.class, () -> new TaskItem("Word", "Desc", "2021-02-31"));
    }
    @Test
    public void creatingTaskItemFailsWithInvalidTitle() {
        assertThrows(IllegalArgumentException.class, () -> new TaskItem("", "Desc", "2021-01-01"));
    }
    @Test
    public void creatingTaskItemSucceedsWithValidDueDate() {
        assertDoesNotThrow(() -> new TaskItem("Word", "Desc", "2021-01-01"));
    }
    @Test
    public void creatingTaskItemSucceedsWithValidTitle() {
        assertDoesNotThrow(() -> new TaskItem("Word", "Desc", "2021-01-01"));
    }
    @Test
    public void settingTaskItemDueDateFailsWithInvalidDate() { //fails
        TaskItem a = new TaskItem("Word", "Desc", "2021-01-01");
        assertThrows(IllegalArgumentException.class, () -> {a.setDate("2021-02-31");});
    }
    @Test
    public void settingTaskItemDueDateSucceedsWithValidDate() {
        TaskItem a = new TaskItem("Word", "Desc", "2021-01-01");
        assertEquals("2021-09-09", a.setDate("2021-09-09"));
    }
    @Test
    public void settingTaskItemTitleFailsWithInvalidTitle() { //fails
        TaskItem a = new TaskItem("Word", "Desc", "2021-01-01");
        assertThrows(IllegalArgumentException.class, () -> {a.setTitle("");});
    }
    @Test
    public void settingTaskItemTitleSucceedsWithValidTitle() {
        TaskItem a = new TaskItem("Word", "Desc", "2021-01-01");
        assertEquals("NewWord", a.setTitle("NewWord"));
    }
}