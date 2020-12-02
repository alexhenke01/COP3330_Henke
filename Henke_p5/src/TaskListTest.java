import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskListTest {

    @Test
    public void addingTaskItemsIncreasesSize()
    {
        TaskList tasks = new TaskList();
        TaskItem task = new TaskItem("Title", "Description", "2021-01-01");
        tasks.add(task);
        assertEquals(1, tasks.size());
    }

    @Test
    public void completingTaskItemChangesStatus()
    {
        TaskList tasks = new TaskList();
        TaskItem task = new TaskItem("Title", "Description", "2021-01-01");
        tasks.add(task);
        task.setComplete(true);
        assertTrue(tasks.completed(task));
    }

    @Test
    public void completingTaskItemFailsWithInvalidIndex()
    {
        TaskList tasks = new TaskList();
        TaskItem task = new TaskItem("Title", "Description", "2021-01-01");
        tasks.add(task);
        assertThrows(IndexOutOfBoundsException.class,()-> tasks.get(1).getComplete());
    }

    @Test
    public void editingTaskItemChangesValues()
    {
        TaskList tasks = new TaskList();
        TaskItem task = new TaskItem("Title", "Description", "2021-01-01");
        tasks.add(task);
        TaskItem edited = new TaskItem("she", "she", "2020-02-02");
        tasks.replace(0, edited);
        assertEquals(edited, tasks.get(0));
    }

    @Test
    public void editingTaskItemDescriptionChangesValue()
    {
        TaskList tasks = new TaskList();
        TaskItem task = new TaskItem("Title", "Description", "2021-01-01");
        tasks.add(task);
        assertEquals("NewTitle", task.setDescription("NewTitle"));
    }

    @Test
    public void editingTaskItemDescriptionFailsWithInvalidIndex()
    {
        TaskList tasks = new TaskList();
        TaskItem task = new TaskItem("Title", "Description", "2021-01-01");
        TaskItem task2 = new TaskItem("Title2", "Description2", "2022-02-02");
        tasks.add(task);
        assertThrows(IndexOutOfBoundsException.class, ()-> tasks.replace(1, task2));
    }

    @Test
    public void editingTaskItemDueDateChangesValue()
    {
        TaskList tasks = new TaskList();
        TaskItem task = new TaskItem("Title", "Description", "2021-01-01");
        TaskItem task2 = new TaskItem("Title2", "Description2", "2022-02-02");
        tasks.add(task);
        tasks.replace(0, task2);
        assertEquals("2022-02-02", tasks.get(0).getDate());
    }
    @Test
    public void editingTaskItemDueDateFailsWithInvalidDateFormat()
    {
        TaskList tasks = new TaskList();
        TaskItem task = new TaskItem("Title", "Description", "2021-01-01");
        TaskItem task2 = new TaskItem("Title2", "Description2", "2021");
        tasks.add(task);
        assertThrows(IllegalArgumentException.class, ()-> tasks.replace(0, task2));
    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidIndex()
    {
        TaskList tasks = new TaskList();
        TaskItem task = new TaskItem("Title", "Description", "2021-01-01");
        TaskItem task2 = new TaskItem("Title2", "Description2", "2022-02-02");
        tasks.add(task);
        assertThrows(IndexOutOfBoundsException.class, ()-> tasks.replace(1, task2));
    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidYYYYMMDD()
    {
        TaskList tasks = new TaskList();
        TaskItem task = new TaskItem("Title", "Description", "2021-01-01");
        TaskItem task2 = new TaskItem("Title2", "Description2", "2022-02-30");
        tasks.add(task);
        assertThrows(IllegalArgumentException.class, ()-> tasks.replace(0, task2));
    }

    @Test
    public void editingTaskItemTitleChangesValue()
    {
        TaskList tasks = new TaskList();
        TaskItem task = new TaskItem("Title", "Description", "2021-01-01");
        TaskItem task2 = new TaskItem("Title2", "Description2", "2022-02-02");
        tasks.add(task);
        tasks.replace(0, task2);
        assertEquals("Title2", tasks.get(0).getTitle());
    }

    @Test
    public void editingTaskItemTitleFailsWithInvalidIndex()
    {
        TaskList tasks = new TaskList();
        TaskItem task = new TaskItem("Title", "Description", "2021-01-01");
        TaskItem task2 = new TaskItem("Title2", "Description2", "2022-02-02");
        tasks.add(task);
        assertThrows(IndexOutOfBoundsException.class, ()-> tasks.replace(1, task2));
    }

    @Test
    public void gettingTaskItemDescriptionFailsWithInvalidIndex()
    {
        TaskList tasks = new TaskList();
        TaskItem task = new TaskItem("Title", "Description", "2021-01-01");
        tasks.add(task);
        assertThrows(IndexOutOfBoundsException.class,()-> tasks.get(1).getDescription());
    }

    @Test
    public void gettingTaskItemDescriptionSucceedsWithValidIndex()
    {
        TaskList tasks = new TaskList();
        TaskItem task = new TaskItem("Title", "Description", "2021-01-01");
        tasks.add(task);
        assertEquals("Description", tasks.get(0).getDescription());
    }

    @Test
    public void gettingTaskItemDueDateFailsWithInvalidIndex()
    {
        TaskList tasks = new TaskList();
        TaskItem task = new TaskItem("Title", "Description", "2021-01-01");
        tasks.add(task);
        assertThrows(IndexOutOfBoundsException.class,()-> tasks.get(1).getDate());
    }

    @Test
    public void gettingTaskItemDueDateSucceedsWithValidIndex()
    {
        TaskList tasks = new TaskList();
        TaskItem task = new TaskItem("Title", "Description", "2021-01-01");
        tasks.add(task);
        assertEquals("2021-01-01", tasks.get(0).getDate());
    }

    @Test
    public void gettingTaskItemTitleFailsWithInvalidIndex()
    {
        TaskList tasks = new TaskList();
        TaskItem task = new TaskItem("Title", "Description", "2021-01-01");
        tasks.add(task);
        assertThrows(IndexOutOfBoundsException.class,()-> tasks.get(1).getTitle());
    }

    @Test
    public void gettingTaskItemTitleSucceedsWithValidIndex()
    {
        TaskList tasks = new TaskList();
        TaskItem task = new TaskItem("Title", "Description", "2021-01-01");
        tasks.add(task);
        assertEquals("Title", tasks.get(0).getTitle());
    }

    @Test
    public void newTaskListIsEmpty()
    {
        TaskList tasks = new TaskList();
        assertEquals(0, tasks.size());
    }

    @Test
    public void removingTaskItemsDecreasesSize()
    {
        TaskList tasks = new TaskList();
        TaskItem a = new TaskItem("Title1", "Description1", "2021-01-01");
        TaskItem b = new TaskItem("Title2", "Description2", "2022-02-02");
        TaskItem c = new TaskItem("Title3", "Description3", "2023-03-03");
        tasks.add(a);
        tasks.add(b);
        tasks.add(c);
        tasks.remove(2);
        assertEquals(2, tasks.size());
    }

    @Test
    public void removingTaskItemsFailsWithInvalidIndex()
    {
        TaskList tasks = new TaskList();
        TaskItem a = new TaskItem("Title1", "Description1", "2021-01-01");
        TaskItem b = new TaskItem("Title2", "Description2", "2022-02-02");
        TaskItem c = new TaskItem("Title3", "Description3", "2023-03-03");
        tasks.add(a);
        tasks.add(b);
        tasks.add(c);
        assertThrows(IndexOutOfBoundsException.class,()-> tasks.remove(3));
    }

    @Test
    public void savedTaskListCanBeLoaded()
    {
        TaskList tasks = new TaskList();
        TaskItem a = new TaskItem("Title1", "Description1", "2021-01-01");
        TaskItem b = new TaskItem("Title2", "Description2", "2022-02-02");
        tasks.add(a);
        tasks.add(b);
        tasks.write("test.txt");
        tasks.read("test.txt");
        assertEquals(a, tasks.get(0));
    }

    @Test
    public void uncompletingTaskItemChangesStatus()
    {
        TaskList tasks = new TaskList();
        TaskItem a = new TaskItem("Title", "Description", "2021-01-01");
        tasks.add(a);
        a.setComplete(true);
        assertFalse(tasks.get(0).setComplete(false));
    }

    @Test
    public void uncompletingTaskItemFailsWithInvalidIndex()
    {
        TaskList tasks = new TaskList();
        TaskItem a = new TaskItem("Title", "Description", "2021-01-01");
        tasks.add(a);
        a.setComplete(true);
        assertThrows(IndexOutOfBoundsException.class, ()-> tasks.get(1).setComplete(false));
    }
}