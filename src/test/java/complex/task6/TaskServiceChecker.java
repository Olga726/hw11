package complex.task6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TaskServiceChecker {
    private TaskService taskService;
    private Task<String> task1;
    private Task<String> task2;
    private Task<String> task3;
    private Task<String> task4;

    @BeforeEach
    void setUp() {
        taskService = new TaskService();

        task1 = new Task<>(LocalDate.of(2025, 10, 01), Status.TO_DO, Priority.HIGH, "1");
        task2 = new Task<>(LocalDate.of(2024, 10, 02), Status.IN_PROGRESS, Priority.LOW, "2");
        task3 = new Task<>(LocalDate.of(2025, 5, 10), Status.DONE, Priority.HIGH, "3");
        task4 = new Task<>(LocalDate.of(2025, 10, 20), Status.TO_DO, Priority.MEDIUM, "4");
    }

    @Test
    public void checkAddUniqueTasks() {
        taskService.addTask(task1);
        taskService.addTask(task2);

        List<Task<String>> tasksList = taskService.sortByDate();
        assertEquals(2, tasksList.size());
        assertTrue(tasksList.contains(task1));
        assertTrue(tasksList.contains(task2));
    }

    @Test
    public void checkUserCanNotAddDuplicates() {
        Task task1Duplicate = new Task<>(LocalDate.of(2025, 10, 01), Status.TO_DO, Priority.HIGH, "1");
        taskService.addTask(task1);
        taskService.addTask(task1Duplicate);

        List<Task<String>> tasksList = taskService.sortByDate();
        assertEquals(1, tasksList.size());
        assertEquals(task1, tasksList.get(0));
    }

    @Test
    public void checkRemoveTask() {
        taskService.addTask(task1);
        taskService.addTask(task2);
        taskService.removeTask(task1.getId());
        taskService.removeTask("invalidID");

        List<Task<String>> tasksList = taskService.sortByDate();
        assertEquals(1, tasksList.size());
        assertEquals(task2, tasksList.get(0));
    }

    @Test
    public void checkfilterByStatus() {
        taskService.addTask(task1);
        taskService.addTask(task2);
        taskService.addTask(task3);
        taskService.addTask(task4);

        List<Task<String>> filteredList = taskService.filterByStatus(task1.getStatus());
        assertEquals(2, filteredList.size());
        assertTrue(filteredList.contains(task1) && filteredList.contains(task4));
    }

    @Test
    public void checkFilterByPriority() {
        taskService.addTask(task1);
        taskService.addTask(task2);
        taskService.addTask(task3);
        taskService.addTask(task4);

        List<Task<String>> filteredList = taskService.filterByPriority(task1.getPriority());
        assertEquals(2, filteredList.size());
        assertTrue(filteredList.contains(task1) && filteredList.contains(task3));
    }

    @Test
    public void checkSortByDate() {
        taskService.addTask(task1);
        taskService.addTask(task2);
        taskService.addTask(task3);

        List<Task<String>> sortedList = taskService.sortByDate();
        assertEquals(List.of(task2, task3, task1), sortedList);

    }

}
