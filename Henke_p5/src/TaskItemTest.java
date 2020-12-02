import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskItemTest {
    @Test
    public void constructorFailsWithInvalidDueDate() {
        assertThrows(IllegalArgumentException.class, () -> new TaskItem("Word", "Desc", "2021-02-31"));
    }
    @Test
    public void constructorFailsWithInvalidTitle() {
        assertThrows(IllegalArgumentException.class, () -> new TaskItem("", "Desc", "2021-01-01"));
    }
    @Test
    public void constructorSucceedsWithValidDueDate() {
        assertDoesNotThrow(() -> new TaskItem("Word", "Desc", "2021-01-01"));
    }
    @Test
    public void constructorSucceedsWithValidTitle() {
        assertDoesNotThrow(() -> new TaskItem("Word", "Desc", "2021-01-01"));
    }
    @Test
    public void editingDescriptionSucceedsWithValidDescription() {
        TaskItem a = new TaskItem("Word", "Desc", "2021-01-01");
        assertEquals("Desc2", a.setDescription("Desc2"));
    }
    @Test
    public void editingDueDateFailsWithInvalidDateFormat() {
        TaskItem a = new TaskItem("Word", "Desc", "2021-01-01");
        assertThrows(IllegalArgumentException.class, () -> {a.setDate("2021");});
    }
    @Test
    public void editingDueDateFailsWithInvalidYYYYMMDD() {
        TaskItem a = new TaskItem("Word", "Desc", "2021-01-01");
        assertThrows(IllegalArgumentException.class, () -> {a.setDate("2021-02-30");});
    }
    @Test
    public void editingDueDateSucceedsWithValidDate() {
        TaskItem a = new TaskItem("Word", "Desc", "2021-01-01");
        assertEquals("2021-09-09", a.setDate("2021-09-09"));
    }
    @Test
    public void editingTitleFailsWithInvalidTitle() {
        TaskItem a = new TaskItem("Word", "Desc", "2021-01-01");
        assertThrows(IllegalArgumentException.class, () -> {a.setTitle("");});
    }
    @Test
    public void editingTitleSucceedsWithValidTitle() {
        TaskItem a = new TaskItem("Word", "Desc", "2021-01-01");
        assertEquals("NewWord", a.setTitle("NewWord"));
    }
}
