package complex.task6;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Task task1 = new Task<>(LocalDate.of(2025, 10, 01), Status.TO_DO, Priority.HIGH, "1");
        Task task2 = new Task<>(LocalDate.of(2025, 10, 02), Status.IN_PROGRESS, Priority.LOW, "2");
        Task task3 = new Task<>(LocalDate.of(2025, 10, 10), Status.DONE, Priority.HIGH, "3");
        Task task4 = new Task<>(LocalDate.of(2025, 10, 20), Status.TO_DO, Priority.MEDIUM, "4q");
        Task task5 = new Task<>(LocalDate.of(2025, 10, 20), Status.TO_DO, Priority.MEDIUM, "4q");

        TaskService taskService = new TaskService();
        taskService.addTask(task4);
        taskService.addTask(task1);
        taskService.addTask(task2);
        taskService.addTask(task3);

        System.out.println(taskService.filterByPriority(Priority.HIGH));
        taskService.removeTask("125as");
        System.out.println(taskService.filterByPriority(Priority.HIGH));
        System.out.println(taskService.filterByStatus(Status.TO_DO));
        System.out.println(taskService.sortByDate());



    }
}
